package com.swszz.eventdrivenbasic.kafka.configuration

import com.swszz.eventdrivenbasic.kafka.specification.ObjectMapperSpecifications
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.converter.RecordMessageConverter
import org.springframework.kafka.support.converter.StringJsonMessageConverter

@Configuration
internal class KafkaConsumerConfiguration {

    /**
     * json string 타입의 메시지를 Any 형태로 변환한다
     */
    @Bean
    fun stringJsonMessageConverter(): RecordMessageConverter {
        return StringJsonMessageConverter(
            ObjectMapperSpecifications.STRING_OBJECT_MAPPER
        )
    }
}