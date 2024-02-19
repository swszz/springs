package com.swszz.cacingstrategy.repository

import com.swszz.cacingstrategy.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

internal interface PostJpaRepository : JpaRepository<PostEntity, Long>