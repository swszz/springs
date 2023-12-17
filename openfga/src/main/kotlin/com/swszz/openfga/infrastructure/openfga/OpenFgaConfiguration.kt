package com.swszz.openfga.infrastructure.openfga

import dev.openfga.sdk.api.client.OpenFgaClient
import dev.openfga.sdk.api.configuration.ClientConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenFgaConfiguration {

    companion object {
        private const val API_URL = "http://localhost:8080"
        private const val STORE_ID: String = "01HHV5QYRM0YYTTJXW1Z8Y30FZ"
    }

    @Bean
    fun openFgaClient(): OpenFgaClient {
        return OpenFgaClient(
            ClientConfiguration()
                .apiUrl(API_URL)
                .storeId(STORE_ID)
        )
    }
}