package com.wompi.ride.ridehailing.dto.rider

import com.wompi.ride.ridehailing.model.Rider
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
abstract class RiderMapper {
    abstract fun toDto(rider: Rider?): RiderDto
    abstract fun toModelFromDto(riderDto: RiderDto): Rider
}
