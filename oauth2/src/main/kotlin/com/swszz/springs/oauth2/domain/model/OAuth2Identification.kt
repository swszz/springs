package com.swszz.springs.oauth2.domain.model

import com.swszz.springs.oauth2.OAuth2Platforms

class OAuth2Identification {
    data class Model(
        val id: Long,
        val platform: OAuth2Platforms,
        val identification: String
    )

    data class Dto(
        val id: Long = 0,
        val platform: OAuth2Platforms,
        val identification: String
    )
}