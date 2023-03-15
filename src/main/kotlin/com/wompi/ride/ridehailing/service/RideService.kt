package com.wompi.ride.ridehailing.service

import com.wompi.ride.ridehailing.dto.ride.RideDto
import com.wompi.ride.ridehailing.dto.ride.RideRequest
import com.wompi.ride.ridehailing.dto.ride.UpdatedRideRequest
import java.util.UUID

interface RideService {
    fun getRideById(uuid: UUID): RideDto
    fun requestRide(ride: RideRequest): RideDto
    fun calculateValue(updatedRideRequest: UpdatedRideRequest): RideDto
}
