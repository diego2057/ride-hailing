package com.wompi.ride.ridehailing.dto.ride

import com.wompi.ride.ridehailing.model.Ride
import org.mapstruct.Mapper
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
abstract class RideMapper {
    abstract fun toDto(ride: Ride?): RideDto
    abstract fun toModel(rideRequest: RideRequest): Ride
    abstract fun toModelFromDto(rideDto: RideDto): Ride
}
