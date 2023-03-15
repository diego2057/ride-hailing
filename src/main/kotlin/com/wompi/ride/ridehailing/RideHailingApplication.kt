package com.wompi.ride.ridehailing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
class RideHailingApplication

fun main(args: Array<String>) { runApplication<RideHailingApplication>(*args) }
