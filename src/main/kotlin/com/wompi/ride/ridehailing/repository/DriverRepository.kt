package com.wompi.ride.ridehailing.repository

import com.wompi.ride.ridehailing.model.Driver
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DriverRepository : JpaRepository<Driver, UUID>
