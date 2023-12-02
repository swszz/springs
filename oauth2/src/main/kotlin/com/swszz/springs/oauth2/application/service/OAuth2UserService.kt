package com.swszz.springs.oauth2.application.service

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service

@Service
class OAuth2UserService() : OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private val resolver: DefaultOAuth2UserService = DefaultOAuth2UserService()
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val oAuth2User: OAuth2User = resolver.loadUser(userRequest)

        for (attribute in oAuth2User.getAttributes()) {
            println(attribute.key + " : " + attribute.value)
        }

        throw Exception("123")
    }
}