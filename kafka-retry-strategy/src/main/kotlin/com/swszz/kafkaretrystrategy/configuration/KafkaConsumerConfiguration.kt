package com.swszz.kafkaretrystrategy.configuration

import com.swszz.kafkaretrystrategy.specification.ObjectMapperSpecifications
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.converter.RecordMessageConverter
import org.springframework.kafka.support.converter.StringJsonMessageConverter

@Configuration
internal class KafkaConsumerConfiguration {
    @Bean
    fun stringJsonMessageConverter(): RecordMessageConverter {
        return StringJsonMessageConverter(
            ObjectMapperSpecifications.STRING_OBJECT_MAPPER
        )
    }
}