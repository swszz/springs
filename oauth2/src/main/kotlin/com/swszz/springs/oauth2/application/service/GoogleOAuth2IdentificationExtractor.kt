package com.swszz.springs.oauth2.application.service

import com.swszz.springs.oauth2.OAuth2Platforms
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component

@Component
internal class GoogleOAuth2IdentificationExtractor : AbstractOAuth2IdentificationExtractor(
    platform = OAuth2Platforms.GOOGLE
) {
    override fun extract(oAuth2User: OAuth2User): OAuth2Identification {
        return when (oAuth2User.attributes.containsKey("email_verified") &&
                oAuth2User.attributes.containsKey("email")) {
            true -> {
                when (oAuth2User.attributes["email_verified"] as Boolean) {
                    true -> DefaultOAuth2Identification.of(
                        value = oAuth2User.attributes["email"] as String
                    )

                    false -> throw IllegalArgumentException("유효하지 않은 계정입니다.")
                }
            }

            false -> throw IllegalArgumentException("유효하지 않은 인증 정보입니다.")
        }
    }
}