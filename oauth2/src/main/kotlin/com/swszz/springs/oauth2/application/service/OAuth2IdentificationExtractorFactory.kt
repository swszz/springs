package com.swszz.springs.oauth2.application.service

import com.swszz.springs.oauth2.OAuth2Platforms
import org.springframework.stereotype.Component

@Component
internal class OAuth2IdentificationExtractorFactory(
    private val extractors: Set<OAuth2IdentificationExtractor>
) {
    private val lookup: Map<OAuth2Platforms, OAuth2IdentificationExtractor> =
        extractors.associateBy { it.getOAuth2Platform() }

    fun getExtractor(platform: OAuth2Platforms): OAuth2IdentificationExtractor {
        return lookup[platform] ?: throw UnsupportedOperationException()
    }
}