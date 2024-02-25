package com.swszz.kafkaretrystrategy.api

import com.swszz.kafkaretrystrategy.KafkaProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class EventController(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    private val kafkaProducer: KafkaProducer,
) {
    @GetMapping("publish")
    fun publish() {
        kafkaProducer.sendWithThrow()
    }

    @GetMapping("publish2")
    fun publish2() {
        kafkaProducer.sendWithoutThrow()
    }
}