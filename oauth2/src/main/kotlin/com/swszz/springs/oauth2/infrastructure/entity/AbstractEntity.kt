package com.swszz.springs.oauth2.infrastructure.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime

@MappedSuperclass
abstract class AbstractEntity(
    @Column
    @CreationTimestamp
    val createdAt: ZonedDateTime? = null,
    @Column
    @UpdateTimestamp
    val updatedAt: ZonedDateTime? = null,
    @Column
    val deletedAt: ZonedDateTime? = null,
)