package com.wompi.ride.ridehailing.service

import com.wompi.ride.ridehailing.dto.driver.DriverDto

interface DriverService {
    fun getAllDrivers(): List<DriverDto>
}
