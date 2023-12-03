package com.swszz.springs.oauth2

enum class OAuth2Platforms(
    val registrationId: String
) {
    KAKAO(registrationId = "kakao"),
    GOOGLE(registrationId = "google"),
}