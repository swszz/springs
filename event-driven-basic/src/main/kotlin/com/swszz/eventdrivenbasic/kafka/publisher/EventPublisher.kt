package com.swszz.eventdrivenbasic.kafka.publisher

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
internal class EventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    fun publish(topic: String, value: String) {
        kafkaTemplate.send(topic, value)
    }
}