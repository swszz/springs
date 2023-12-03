package com.swszz.springs.oauth2.application.service

internal data class DefaultOAuth2Identification(
    private val value: String
) : OAuth2Identification {
    companion object {
        fun of(value: String): OAuth2Identification {
            return DefaultOAuth2Identification(value = value)
        }
    }

    override fun getIdentification(): String {
        return value
    }
}