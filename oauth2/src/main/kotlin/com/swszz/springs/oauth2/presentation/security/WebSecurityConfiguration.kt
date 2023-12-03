package com.swszz.springs.oauth2.presentation.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableMethodSecurity
class WebSecurityConfiguration(
    private val oAuth2UserService: OAuth2UserService<OAuth2UserRequest, OAuth2User>
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http.cors { it.disable() }
            .csrf { it.disable() }
            .httpBasic { it.disable() }
            .formLogin { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .authorizeHttpRequests { it.anyRequest().permitAll() }
            .oauth2Login {
                it.successHandler(AuthenticationSuccessHandler())
                it.failureHandler(AuthenticationFailureHandler())
                it.userInfoEndpoint { endpoint ->
                    endpoint.userService(oAuth2UserService)
                }
            }.build()
    }
}