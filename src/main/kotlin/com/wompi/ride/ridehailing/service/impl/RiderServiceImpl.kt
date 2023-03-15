package com.wompi.ride.ridehailing.service.impl

import com.wompi.ride.ridehailing.client.WompiClient
import com.wompi.ride.ridehailing.dto.client.PaymentCard
import com.wompi.ride.ridehailing.dto.rider.RiderDto
import com.wompi.ride.ridehailing.dto.rider.RiderMapper
import com.wompi.ride.ridehailing.repository.RiderRepository
import com.wompi.ride.ridehailing.service.RiderService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service("rider.crud_service")
class RiderServiceImpl(
        private val riderRepository: RiderRepository,
        private val riderMapper: RiderMapper,
        private val wompiClient: WompiClient
) : RiderService {

    @Value("\${app.wompi-ms.public-token}")
    lateinit var pubToken: String
    @Value("\${app.wompi-ms.private-token}")
    lateinit var privateToken: String
    @Value("\${app.wompi-ms.type}")
    lateinit var typePayment: String

    @Transactional
    override fun createPaymentMethod(uuid: UUID): RiderDto {
        val rider = riderRepository.findById(uuid).orElseThrow {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        try {
            val merchant = wompiClient.merchantsToken(pubToken)
            val paymentCard = PaymentCard(
                    typePayment, rider.token, rider.email,
                    merchant.data.presignedAcceptance.acceptanceToken
            )
            val paymentSource = wompiClient.paymentSource(paymentCard, privateToken)
            rider.paymentSourceID = paymentSource.data.id

            return riderMapper.toDto(riderRepository.save(rider))
        } catch (e: Exception){
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.message)
        }
    }

    override fun getAllRiders(): List<RiderDto> {
        return riderRepository.findAll().map(riderMapper::toDto)
    }
}
