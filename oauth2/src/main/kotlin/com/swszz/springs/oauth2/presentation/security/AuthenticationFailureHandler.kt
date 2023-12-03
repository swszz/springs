package com.swszz.springs.oauth2.presentation.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler

class AuthenticationFailureHandler : AuthenticationFailureHandler {
    private val resolver: SimpleUrlAuthenticationFailureHandler = SimpleUrlAuthenticationFailureHandler()
    override fun onAuthenticationFailure(
        request: HttpServletRequest,
        response: HttpServletResponse,
        exception: AuthenticationException
    ) {
        resolver.onAuthenticationFailure(request, response, exception)
    }
}