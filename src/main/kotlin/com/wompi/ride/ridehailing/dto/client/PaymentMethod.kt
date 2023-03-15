package com.wompi.ride.ridehailing.dto.client

data class PaymentMethod(
    val name: String,
    val paymentProcessors: List<PaymentProcessor>
)
