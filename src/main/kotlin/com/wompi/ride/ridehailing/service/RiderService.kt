package com.wompi.ride.ridehailing.service

import com.wompi.ride.ridehailing.dto.rider.RiderDto
import java.util.UUID

interface RiderService {
    fun createPaymentMethod(uuid: UUID): RiderDto
    fun getAllRiders(): List<RiderDto>
}
