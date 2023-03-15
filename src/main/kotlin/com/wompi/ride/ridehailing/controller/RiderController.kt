package com.wompi.ride.ridehailing.controller

import com.wompi.ride.ridehailing.dto.rider.RiderDto
import com.wompi.ride.ridehailing.service.RiderService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/riders")
class RiderController(private val riderService: RiderService) {
    @GetMapping("/{uuid}")
    fun createPaymentMethod(@PathVariable uuid: UUID): ResponseEntity<RiderDto> {
        val rider = riderService.createPaymentMethod(uuid)
        return ResponseEntity.ok(rider)
    }

    @GetMapping
    fun getAllRiders(): ResponseEntity<List<RiderDto>> {
        val riders = riderService.getAllRiders()
        return ResponseEntity.ok(riders)
    }
}
