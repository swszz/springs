package com.swszz.openfga.infrastructure.openfga

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime

@Entity
@Table(name = "store")
class Store(
    @Column
    val name: String,
    @Column(name = "updated_at")
    val updatedAt: ZonedDateTime?,
    @Column(name = "deleted_at")
    val deletedAt: ZonedDateTime?,
    @Column(name = "created_at")
    val createdAt: ZonedDateTime?,
) {
    @Id
    @Column(name = "id", nullable = false)
    val id: String? = null
}