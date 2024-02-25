package com.swszz.eventdrivenbasic.kafka.listener

import com.swszz.eventdrivenbasic.kafka.constant.KafkaTopics
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
internal class EventListeners {
    @KafkaListener(topics = [KafkaTopics.SAMPLE], autoStartup = "true")
    fun listen(value: String) {
        println("@@@")
        println(value)
        println("@@@")
    }
}