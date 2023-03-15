package com.wompi.ride.ridehailing.model

import jakarta.persistence.Entity

@Entity
data class Driver(
    var name: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null
) : BaseModel()
