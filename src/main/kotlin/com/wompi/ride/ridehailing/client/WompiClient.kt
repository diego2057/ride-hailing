package com.wompi.ride.ridehailing.client

import com.wompi.ride.ridehailing.dto.client.*
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "wompi", url = "\${app.wompi-ms.url}")
interface WompiClient {
    @GetMapping("merchants/{pubToken}", consumes = ["application/json"], produces = ["application/json"])
    fun merchantsToken(
        @PathVariable pubToken: String
    ): Merchant

    @PostMapping("tokens/cards", consumes = ["application/json"], produces = ["application/json"])
    fun tokenized(
            @RequestBody cardPrivateData: CardPrivateData,
            @RequestHeader(
                    value = "Authorization",
                    defaultValue = "Bearer \${app.wompi-ms.public-token}"
            ) publicToken: String
    ): CardResponse

    @PostMapping("payment_sources", consumes = ["application/json"], produces = ["application/json"])
    fun paymentSource(
        @RequestBody paymentCard: PaymentCard,
        @RequestHeader(
            value = "Authorization",
            defaultValue = "Bearer \${app.wompi-ms.private-token}"
        ) privateToken: String
    ): Card
}
