package com.swszz.springs.oauth2.application.service

import com.swszz.springs.oauth2.OAuth2Platforms
import com.swszz.springs.oauth2.domain.reader.OAuth2IdentificationReader
import com.swszz.springs.oauth2.domain.store.OAuth2IdentificationStore
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class OAuth2UserService(
    private val oAuth2IdentificationExtractorFactory: OAuth2IdentificationExtractorFactory,
    private val oAuth2IdentificationReader: OAuth2IdentificationReader,
    private val oAuth2IdentificationStore: OAuth2IdentificationStore,
) : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    private val resolver: DefaultOAuth2UserService = DefaultOAuth2UserService()

    @Transactional
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {

        val platform: OAuth2Platforms =
            when (userRequest.clientRegistration.registrationId.lowercase()) {
                OAuth2Platforms.KAKAO.registrationId -> OAuth2Platforms.KAKAO
                OAuth2Platforms.GOOGLE.registrationId -> OAuth2Platforms.GOOGLE
                else -> {
                    throw UnsupportedOperationException("등록되지 않은 소셜 서비스입니다.")
                }
            }

        val oAuth2IdentificationExtractor: OAuth2IdentificationExtractor =
            this.oAuth2IdentificationExtractorFactory.getExtractor(platform = platform)

        val oAuth2User: OAuth2User = resolver.loadUser(userRequest)

        val identification: OAuth2Identification =
            oAuth2IdentificationExtractor.extract(oAuth2User = oAuth2User)

        val oAuth2Identification: com.swszz.springs.oauth2.domain.model.OAuth2Identification.Dto =
            com.swszz.springs.oauth2.domain.model.OAuth2Identification.Dto(
                platform = platform,
                identification = identification.getIdentification()
            )

        return when (oAuth2IdentificationReader.existByPlatformAndIdentification(dto = oAuth2Identification)) {
            true -> {
                logger.info("해당 인증 정보가 존재합니다.")
                oAuth2User
            }

            false -> {
                logger.info("해당 인증 정보가 존재하지 않습니다.")
                logger.info("새로운 인증 정보를 저장합니다.")
                oAuth2IdentificationStore.save(dto = oAuth2Identification)
                oAuth2User
            }
        }
    }
}