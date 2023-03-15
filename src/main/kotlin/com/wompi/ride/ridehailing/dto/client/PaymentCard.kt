package com.wompi.ride.ridehailing.dto.client

data class PaymentCard(
        val type: String? = "CARD",
        var token: String? = null,
        var customerEmail: String? = null,
        var acceptanceToken: String? = null
)
