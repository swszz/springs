package com.swszz.springs.oauth2.domain.store

import com.swszz.springs.oauth2.domain.model.OAuth2Identification

interface OAuth2IdentificationStore {
    fun save(dto: OAuth2Identification.Dto): OAuth2Identification.Dto
}