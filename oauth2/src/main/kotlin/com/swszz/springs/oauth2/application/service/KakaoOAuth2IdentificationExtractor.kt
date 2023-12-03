package com.swszz.springs.oauth2.application.service

import com.swszz.springs.oauth2.OAuth2Platforms
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component

@Component
internal class KakaoOAuth2IdentificationExtractor : AbstractOAuth2IdentificationExtractor(
    platform = OAuth2Platforms.KAKAO
) {
    override fun extract(oAuth2User: OAuth2User): OAuth2Identification {
        return when (oAuth2User.attributes.containsKey("id")) {
            true -> DefaultOAuth2Identification.of(
                value = oAuth2User.attributes["id"] as String
            )
            false -> throw IllegalArgumentException("유효하지 않은 계정입니다.")
        }
    }
}