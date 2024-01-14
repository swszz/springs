package com.swszz.kafkaretrystrategy.listener

import com.swszz.kafkaretrystrategy.constant.KafkaTopics
import com.swszz.kafkaretrystrategy.event.SampleEvent2
import com.swszz.kafkaretrystrategy.extension.toJsonString
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class SampleListener {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = [KafkaTopics.SAMPLE], autoStartup = "true")
    fun listen(event: SampleEvent2) {
        logger.info(event.toJsonString())
    }
}