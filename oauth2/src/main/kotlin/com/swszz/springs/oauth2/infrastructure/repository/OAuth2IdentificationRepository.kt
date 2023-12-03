package com.swszz.springs.oauth2.infrastructure.repository

import com.swszz.springs.oauth2.domain.model.OAuth2Identification
import com.swszz.springs.oauth2.domain.reader.OAuth2IdentificationReader
import com.swszz.springs.oauth2.domain.store.OAuth2IdentificationStore
import com.swszz.springs.oauth2.infrastructure.repository.jpa.OAuth2IdentificationJpaRepository
import com.swszz.springs.oauth2.infrastructure.repository.mapper.toDto
import com.swszz.springs.oauth2.infrastructure.repository.mapper.toEntity
import org.springframework.stereotype.Repository

@Repository
internal class OAuth2IdentificationRepository(
    private val jpaRepository: OAuth2IdentificationJpaRepository
) : OAuth2IdentificationReader, OAuth2IdentificationStore {
    override fun existByPlatformAndIdentification(dto: OAuth2Identification.Dto): Boolean {
        return this.jpaRepository.existsByPlatformAndIdentification(
            platform = dto.platform,
            identification = dto.identification
        )
    }

    override fun save(dto: OAuth2Identification.Dto): OAuth2Identification.Dto {
        return this.jpaRepository.save(dto.toEntity()).toDto()
    }
}