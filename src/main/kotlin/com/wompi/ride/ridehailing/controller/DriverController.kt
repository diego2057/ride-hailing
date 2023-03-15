package com.wompi.ride.ridehailing.controller

import com.wompi.ride.ridehailing.dto.driver.DriverDto
import com.wompi.ride.ridehailing.service.DriverService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/drivers")
class DriverController(private val driverService: DriverService) {

    @GetMapping
    fun getAllDrivers(): ResponseEntity<List<DriverDto>> {
        val drivers = driverService.getAllDrivers()
        return ResponseEntity.ok(drivers)
    }
}
