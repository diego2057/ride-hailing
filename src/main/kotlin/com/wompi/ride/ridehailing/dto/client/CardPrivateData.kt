package com.wompi.ride.ridehailing.dto.client

data class CardPrivateData(
    val number: String? = "4242424242424242",
    val expMonth: String? = "06",
    val expYear: String? = "29",
    val cvc: String? = "123",
    val cardHolder: String? = "Pedro Pérez"
)
