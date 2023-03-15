package com.wompi.ride.ridehailing.dto.client

data class PaymentMethod(
    val name: String? = null,
    val paymentProcessors: List<PaymentProcessor>? = null
)
