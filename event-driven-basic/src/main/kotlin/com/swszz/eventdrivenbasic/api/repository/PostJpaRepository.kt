package com.swszz.eventdrivenbasic.api.repository

import com.swszz.eventdrivenbasic.api.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

internal interface PostJpaRepository : JpaRepository<PostEntity, Long>