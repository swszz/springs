package com.swszz.cacingstrategy.entity

import jakarta.persistence.*
import org.hibernate.annotations.SQLRestriction
import java.time.ZonedDateTime

@Entity
@Table(name = "Post")
@SQLRestriction("deleted_at is null")
internal class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    val id: Long = 0L,

    @Column(columnDefinition = "TEXT")
    val content: String,

    @Column
    val deletedAt: ZonedDateTime? = null
)