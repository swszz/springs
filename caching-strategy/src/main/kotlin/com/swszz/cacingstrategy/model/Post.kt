package com.swszz.cacingstrategy.model

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PositiveOrZero
import java.io.Serializable
import java.time.ZonedDateTime


internal data class Post(
    @field:NotNull
    @field:PositiveOrZero
    val id: Long,
    @field:NotNull
    val content: String,
    val deletedAt: ZonedDateTime? = null,
) : Serializable