package com.swszz.cacingstrategy.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka


@EnableKafka
@Configuration
class KafkaTransactionConfiguration {

    @Bean
    fun newTopic(): NewTopic {
        return NewTopic("sample2277", 3, 3)
    }
}