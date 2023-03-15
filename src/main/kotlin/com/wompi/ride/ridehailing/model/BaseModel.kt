package com.wompi.ride.ridehailing.model

import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID

@MappedSuperclass
abstract class BaseModel() {
    @Id
    open var uuid: UUID = UUID.randomUUID()

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    open var createdAt: LocalDateTime? = LocalDateTime.now()

    @Column(name = "last_modified_at")
    @LastModifiedDate
    open var lastModifiedAt: LocalDateTime? = LocalDateTime.now()

    @Column(name = "created_by")
    @CreatedBy
    open var createdBy: String? = null

    @Column(name = "modified_by")
    @LastModifiedBy
    open var modifiedBy: String? = null
}
