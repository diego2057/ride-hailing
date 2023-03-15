package com.wompi.ride.ridehailing.dto.client

data class Data(
    /*val id: Int,
    val name: String,
    val email: String,
    val contactName: String,
    val phoneNumber: String,
    val active: Boolean,
    val logoUrl: String?,
    val legalName: String,
    val legalIdType: String,
    val legalId: String,
    val publicKey: String,
    val acceptedCurrencies: List<String>,
    val fraudJavascriptKey: String?,
    val fraudGroups: List<Any>,
    val acceptedPaymentMethods: List<String>,
    val paymentMethods: List<PaymentMethod>,*/
    val presignedAcceptance: PresignedAcceptance
)
