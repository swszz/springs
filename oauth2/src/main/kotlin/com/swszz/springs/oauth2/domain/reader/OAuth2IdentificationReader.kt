package com.swszz.springs.oauth2.domain.reader

import com.swszz.springs.oauth2.domain.model.OAuth2Identification

interface OAuth2IdentificationReader {
    fun existByPlatformAndIdentification(dto: OAuth2Identification.Dto): Boolean
}