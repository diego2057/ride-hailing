package com.wompi.ride.ridehailing.dto.client

data class PresignedAcceptance(
    val acceptanceToken: String,
    val permalink: String,
    val type: String
)
