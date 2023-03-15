package com.wompi.ride.ridehailing.dto.driver

import com.wompi.ride.ridehailing.model.Driver
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
abstract class DriverMapper {
    abstract fun toDto(driver: Driver?): DriverDto
    abstract fun toModelFromDto(driverDto: DriverDto): Driver
}
