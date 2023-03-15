package com.wompi.ride.ridehailing.dto.ride

import com.wompi.ride.ridehailing.dto.request.OnCreate
import com.wompi.ride.ridehailing.model.Driver
import com.wompi.ride.ridehailing.model.Rider
import com.wompi.ride.ridehailing.model.enums.StatusEnum
import jakarta.validation.constraints.NotNull
import java.util.UUID

class RideDto {
    var uuid: UUID? = null
    @NotNull(groups = [OnCreate::class])
    var rider: Rider? = null
    var driver: Driver? = null
    var latitudeSource: Double? = null
    var longitudeSource: Double? = null
    var latitudeFinal: Double? = null
    var longitudeFinal: Double? = null
    var valor: Double? = null
    var status: StatusEnum? = StatusEnum.free
}
