package com.wompi.ride.ridehailing.dto.client

data class CardPublicData(
    val bin: String,
    val lastFour: String,
    val expMonth: String,
    val expYear: String,
    val cardHolder: String,
    val validityEndsAt: String,
    val type: String
)
