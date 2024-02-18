package com.swszz.rediscircuitbreaker

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "Post")
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