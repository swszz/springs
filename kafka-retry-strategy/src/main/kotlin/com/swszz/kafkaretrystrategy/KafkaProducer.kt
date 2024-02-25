package com.swszz.kafkaretrystrategy

import com.swszz.kafkaretrystrategy.constant.KafkaTopics
import com.swszz.kafkaretrystrategy.event.SampleEvent
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Component
class KafkaProducer(
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    @Transactional
    fun sendWithThrow() {
        println("sendWithThrow")
        kafkaTemplate.executeInTransaction {
            it.send(KafkaTopics.SAMPLE, SampleEvent(id = UUID.randomUUID().toString()))
        }
        throw RuntimeException()
    }

    @Transactional
    fun sendWithoutThrow() {
        println("sendWithoutThrow")
        kafkaTemplate.executeInTransaction {
            it.send(KafkaTopics.SAMPLE, SampleEvent(id = UUID.randomUUID().toString()))
        }
    }

    @KafkaListener(groupId = "1", topics = [KafkaTopics.SAMPLE])
    fun test(event: SampleEvent) {
        println("@@@@")
        println(event)
        println("@@@@")
    }
}