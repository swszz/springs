package com.swszz.rediscircuitbreaker

import org.springframework.data.jpa.repository.JpaRepository

internal interface PostJpaRepository : JpaRepository<PostEntity, Long>