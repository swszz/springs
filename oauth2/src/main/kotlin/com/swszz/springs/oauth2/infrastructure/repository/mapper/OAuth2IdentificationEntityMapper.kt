package com.swszz.springs.oauth2.infrastructure.repository.mapper

import com.swszz.springs.oauth2.domain.model.OAuth2Identification
import com.swszz.springs.oauth2.infrastructure.entity.OAuth2IdentificationEntity

internal fun OAuth2IdentificationEntity.toDto(): OAuth2Identification.Dto {
    return OAuth2Identification.Dto(
        id = this.id,
        platform = this.platform,
        identification = this.identification
    )
}

internal fun OAuth2Identification.Dto.toEntity(): OAuth2IdentificationEntity {
    return OAuth2IdentificationEntity(
        id = this.id,
        platform = this.platform,
        identification = this.identification
    )
}