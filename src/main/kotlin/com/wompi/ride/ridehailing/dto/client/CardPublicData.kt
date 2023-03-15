package com.wompi.ride.ridehailing.dto.client

data class CardPublicData(
    val bin: String? = null,
    val lastFour: String? = null,
    val expMonth: String? = null,
    val expYear: String? = null,
    val cardHolder: String? = null,
    val validityEndsAt: String? = null,
    val type: String? = null
)
