package com.wompi.ride.ridehailing.dto.client

data class CardData(
    val id: Int,
    val publicData: CardPublicData,
    val token: String,
    val type: String,
    val status: String,
    val customerEmail: String
)
