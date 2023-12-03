package com.swszz.springs.oauth2.presentation.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler

class AuthenticationSuccessHandler() : AuthenticationSuccessHandler {

    private val resolver: SimpleUrlAuthenticationSuccessHandler = SimpleUrlAuthenticationSuccessHandler()
    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        resolver.onAuthenticationSuccess(request, response, authentication)
    }
}