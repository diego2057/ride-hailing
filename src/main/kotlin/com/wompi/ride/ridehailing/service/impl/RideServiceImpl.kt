package com.wompi.ride.ridehailing.service.impl

import com.wompi.ride.ridehailing.dto.ride.RideDto
import com.wompi.ride.ridehailing.dto.ride.RideRequest
import com.wompi.ride.ridehailing.dto.ride.UpdatedRideRequest
import com.wompi.ride.ridehailing.service.RideService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service("ride.crud_service")
class RideServiceImpl : RideService {
    override fun getRideById(uuid: UUID): RideDto {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun requestRide(ride: RideRequest): RideDto {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun calculateValue(updatedRideRequest: UpdatedRideRequest): RideDto {
        TODO("Not yet implemented")
    }
}
