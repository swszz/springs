package com.swszz.rediscircuitbreaker.repository

import com.swszz.rediscircuitbreaker.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

internal interface PostJpaRepository : JpaRepository<PostEntity, Long>