package com.swszz.spicedb.configuration

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
 class SpringDocConfiguration {
    @Bean
    fun openApi(): OpenAPI = OpenAPI()
        .components(components())

    private fun components() = Components()
}