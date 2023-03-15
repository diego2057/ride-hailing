package com.wompi.ride.ridehailing.dto.ride

import com.wompi.ride.ridehailing.dto.request.OnCreate
import com.wompi.ride.ridehailing.model.enums.StatusEnum
import jakarta.validation.constraints.NotNull
import java.util.UUID

class UpdatedRideRequest {
    @NotNull(groups = [OnCreate::class])
    var driverUuid: UUID? = null
    @NotNull(groups = [OnCreate::class])
    var latitudeFinal: Double? = null
    @NotNull(groups = [OnCreate::class])
    var longitudeFinal: Double? = null
    var status: StatusEnum? = StatusEnum.finished
}
