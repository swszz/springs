package com.swszz.springs.oauth2.application.service

import com.swszz.springs.oauth2.OAuth2Platforms

internal sealed class AbstractOAuth2IdentificationExtractor(
    private val platform: OAuth2Platforms
) : OAuth2IdentificationExtractor {
    override fun getOAuth2Platform() = platform
}