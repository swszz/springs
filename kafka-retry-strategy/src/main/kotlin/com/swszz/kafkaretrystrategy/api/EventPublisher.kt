package com.swszz.kafkaretrystrategy.api

import com.swszz.kafkaretrystrategy.constant.KafkaTopics
import com.swszz.kafkaretrystrategy.event.SampleEvent
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class EventPublisher(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    @GetMapping("publish")
    fun publish() {
        kafkaTemplate.send(
            KafkaTopics.SAMPLE, SampleEvent(id = UUID.randomUUID().toString())
        )
    }
}