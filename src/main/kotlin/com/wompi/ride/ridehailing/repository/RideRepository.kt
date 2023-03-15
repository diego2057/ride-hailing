package com.wompi.ride.ridehailing.repository

import com.wompi.ride.ridehailing.model.Driver
import com.wompi.ride.ridehailing.model.Ride
import com.wompi.ride.ridehailing.model.enums.StatusEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RideRepository : JpaRepository<Ride, UUID> {
    fun findByStatusAndDriver(status: StatusEnum, driver: Driver): Ride
}
