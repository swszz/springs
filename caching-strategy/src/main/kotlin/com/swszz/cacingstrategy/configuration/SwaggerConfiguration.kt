package com.swszz.cacingstrategy.configuration

import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class SwaggerConfiguration {
    @Bean
    fun openAPI() = OpenAPI()
}