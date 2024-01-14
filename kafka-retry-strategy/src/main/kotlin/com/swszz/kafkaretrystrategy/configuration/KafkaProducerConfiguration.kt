package com.swszz.kafkaretrystrategy.configuration

import com.swszz.kafkaretrystrategy.serializer.AnyToJsonStringSerializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.*


@Configuration
@EnableConfigurationProperties(KafkaProperties::class)
internal class KafkaProducerConfiguration {
    @Bean
    fun producerFactory(
        kafkaProperties: KafkaProperties
    ): ProducerFactory<*, *> {
        val producerFactory: DefaultKafkaProducerFactory<String, Any> =
            DefaultKafkaProducerFactory<String, Any>(kafkaProperties.buildProducerProperties())
        producerFactory.keySerializer = StringSerializer()
        producerFactory.valueSerializer = AnyToJsonStringSerializer()
        return producerFactory
    }
}