package com.wompi.ride.ridehailing.service.impl

import com.wompi.ride.ridehailing.client.WompiClient
import com.wompi.ride.ridehailing.dto.ride.*
import com.wompi.ride.ridehailing.model.Driver
import com.wompi.ride.ridehailing.model.Ride
import com.wompi.ride.ridehailing.model.enums.StatusEnum
import com.wompi.ride.ridehailing.repository.DriverRepository
import com.wompi.ride.ridehailing.repository.RideRepository
import com.wompi.ride.ridehailing.repository.RiderRepository
import com.wompi.ride.ridehailing.service.RideService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime
import java.util.UUID
import kotlin.math.*

@Service("ride.crud_service")
class RideServiceImpl(
        private val rideRepository: RideRepository,
        private val riderRepository: RiderRepository,
        private val rideMapper: RideMapper,
        private val driverRepository: DriverRepository,
        private val wompiClient: WompiClient
) : RideService {

    val R = 6371
    val VAL_KM = 1000
    val VAL_MIN = 200
    override fun getRideById(uuid: UUID): RideDto {
        return rideRepository.findById(uuid).map(
            rideMapper::toDto)
        .orElseThrow {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    @Transactional
    override fun requestRide(ride: RideRequest): RideDto {
        val driver = findClosestDriver(ride, driverRepository.findAll())
        val rider = riderRepository.findById(ride.riderUuid!!).orElseThrow {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Rider not found")
        }
        val ride = Ride().apply {
            this.driver = driver
            this.rider = rider
            this.longitudeSource = ride.longitudeSource
            this.latitudeSource = ride.latitudeSource
        }
        return rideMapper.toDto(rideRepository.save(ride))
    }

    @Transactional
    override fun finishRide(updatedRideRequest: UpdatedRideRequest): RideDto {
        val driver = driverRepository.findById(updatedRideRequest.driverUuid!!).orElseThrow {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Driver not found")
        }
        var ride = rideRepository.findByStatusAndDriver(StatusEnum.onRide, driver)
        ride.latitudeFinal = updatedRideRequest.latitudeFinal
        ride.longitudeFinal = updatedRideRequest.longitudeFinal
        calculateValue(ride)
        driver.latitude = updatedRideRequest.latitudeFinal
        driver.longitude = updatedRideRequest.longitudeFinal
        driverRepository.save(driver)

        createTransaction(ride)
        return rideMapper.toDto(rideRepository.save(ride))
    }

    private fun createTransaction(ride: Ride) {

    }

    private fun calculateValue(ride: Ride) {
        val finalLocation = Location(ride.latitudeFinal, ride.longitudeFinal)
        val sourceLocation = Location(ride.latitudeSource, ride.longitudeSource)
        val distance = distanceTo(finalLocation, sourceLocation)
        val time =  (LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC) -
                ride.createdAt!!.toEpochSecond(java.time.ZoneOffset.UTC)) / 60
        ride.value = distance * VAL_KM + time * VAL_MIN
    }

    private fun distanceTo(driver: Location, ride: Location): Double {
        val lat1 = Math.toRadians(ride.latitude!!)
        val lon1 = Math.toRadians(ride.longitude!!)
        val lat2 = Math.toRadians(driver.latitude!!)
        val lon2 = Math.toRadians(driver.longitude!!)
        val dLat = lat2 - lat1
        val dLon = lon2 - lon1
        val a = sin(dLat / 2).pow(2) + cos(lat1) * cos(lat2) * sin(dLon / 2).pow(2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        return R * c
    }

    private fun findClosestDriver(ride: RideRequest, driverList: List<Driver>): Driver? {
        var closestDriver: Driver? = null
        var closestDistance = Double.MAX_VALUE
        for (driver in driverList) {
            val driverLocation = Location(driver.latitude, ride.longitudeSource)
            val riderLocation = Location(driver.latitude, ride.longitudeSource)
            val distance = distanceTo(driverLocation, riderLocation)
            if (distance < closestDistance) {
                closestDistance = distance
                closestDriver = driver
            }
        }
        return closestDriver
    }
}
