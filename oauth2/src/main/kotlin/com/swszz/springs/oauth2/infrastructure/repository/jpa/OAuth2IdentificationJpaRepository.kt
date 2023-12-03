package com.swszz.springs.oauth2.infrastructure.repository.jpa

import com.swszz.springs.oauth2.OAuth2Platforms
import com.swszz.springs.oauth2.infrastructure.entity.OAuth2IdentificationEntity
import org.springframework.data.jpa.repository.JpaRepository

internal interface OAuth2IdentificationJpaRepository : JpaRepository<OAuth2IdentificationEntity, Long> {
    fun existsByPlatformAndIdentification(
        platform: OAuth2Platforms,
        identification: String
    ): Boolean
}