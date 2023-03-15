package com.wompi.ride.ridehailing.service.impl

import com.wompi.ride.ridehailing.dto.driver.DriverDto
import com.wompi.ride.ridehailing.dto.driver.DriverMapper
import com.wompi.ride.ridehailing.repository.DriverRepository
import com.wompi.ride.ridehailing.service.DriverService
import org.springframework.stereotype.Service

@Service("driver.crud_service")
class DriverServiceImpl(
    private val driverRepository: DriverRepository,
    private val driverMapper: DriverMapper
) : DriverService {
    override fun getAllDrivers(): List<DriverDto> {
        return driverRepository.findAll().map(driverMapper::toDto)
    }
}
