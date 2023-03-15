package com.wompi.ride.ridehailing.controller

import com.wompi.ride.ridehailing.dto.ride.RideDto
import com.wompi.ride.ridehailing.dto.ride.RideRequest
import com.wompi.ride.ridehailing.dto.ride.UpdatedRideRequest
import com.wompi.ride.ridehailing.service.RideService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/rides")
class RideController(private val rideService: RideService) {
    @GetMapping("/{uuid}")
    fun getRideById(@PathVariable uuid: UUID): ResponseEntity<RideDto> {
        val ride = rideService.getRideById(uuid)
        return ResponseEntity.ok(ride)
    }

    @PostMapping("/rider")
    fun createRide(@RequestBody ride: RideRequest): ResponseEntity<RideDto> {
        val createdRide = rideService.requestRide(ride)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRide)
    }

    @PatchMapping("/driver")
    fun updateRide(@ModelAttribute updatedRideRequest: UpdatedRideRequest): ResponseEntity<RideDto> {
        return ResponseEntity.ok(rideService.calculateValue(updatedRideRequest))
    }
}
