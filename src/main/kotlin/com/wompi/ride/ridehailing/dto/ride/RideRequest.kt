package com.wompi.ride.ridehailing.dto.ride

import com.wompi.ride.ridehailing.dto.request.OnCreate
import jakarta.validation.constraints.NotNull
import java.util.UUID

class RideRequest {
    @NotNull(groups = [OnCreate::class])
    var riderUuid: UUID? = null
    @NotNull(groups = [OnCreate::class])
    var latitudeSource: Double? = null
    @NotNull(groups = [OnCreate::class])
    var longitudeSource: Double? = null
}
