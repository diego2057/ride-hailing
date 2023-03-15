package com.wompi.ride.ridehailing.model

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
data class Rider(
    @Column(name = "payment_source_id")
    var paymentSourceID: Int? = null,
    var name: String? = null,
    var token: String? = null,
    var email: String? = null
) : BaseModel()
