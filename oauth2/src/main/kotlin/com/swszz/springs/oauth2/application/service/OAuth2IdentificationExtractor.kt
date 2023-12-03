package com.swszz.springs.oauth2.application.service

import com.swszz.springs.oauth2.OAuth2Platforms
import org.springframework.security.oauth2.core.user.OAuth2User

internal interface OAuth2IdentificationExtractor {
    fun extract(oAuth2User: OAuth2User): OAuth2Identification
    fun getOAuth2Platform(): OAuth2Platforms
}