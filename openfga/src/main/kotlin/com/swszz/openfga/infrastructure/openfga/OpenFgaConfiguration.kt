package com.swszz.openfga.infrastructure.openfga

import dev.openfga.sdk.api.client.OpenFgaClient
import dev.openfga.sdk.api.configuration.ClientConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenFgaConfiguration {

    companion object {
        private const val API_URL = "http://localhost:8080"
        private const val STORE_ID: String = "store_id"
    }

    @Bean
    fun openFgaClient(): OpenFgaClient {
        val config: ClientConfiguration = ClientConfiguration()
            .apiUrl(API_URL)
//            .authorizationModelId(System.getenv("FGA_AUTHORIZATION_MODEL_ID")) // Optional, can be overridden per request

        return OpenFgaClient(config)
    }
}