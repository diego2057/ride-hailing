package com.wompi.ride.ridehailing.repository

import com.wompi.ride.ridehailing.model.Rider
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RiderRepository : JpaRepository<Rider, UUID>
