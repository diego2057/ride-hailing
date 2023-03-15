package com.wompi.ride.ridehailing.model

import com.wompi.ride.ridehailing.model.enums.StatusEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Ride(
        @ManyToOne
    @JoinColumn(nullable = false)
    var rider: Rider? = null,
        @ManyToOne
    @JoinColumn(nullable = false)
    var driver: Driver? = null,
        @Column(name = "latitude_source", updatable = false)
    var latitudeSource: Double? = null,
        @Column(name = "longitude_source", updatable = false)
    var longitudeSource: Double? = null,
        @Column(name = "latitude_final")
    var latitudeFinal: Double? = null,
        @Column(name = "longitude_final")
    var longitudeFinal: Double? = null,
    var value: Double? = null,
    var status: StatusEnum? = StatusEnum.onRide
) : BaseModel()
