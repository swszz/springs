package com.swszz.kafkaretrystrategy.specification

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component

@Component
internal class DeadLetterHandler {

    private val log = LoggerFactory.getLogger(javaClass)

    fun handle(
        record: ConsumerRecord<String, String>,
        @Header(KafkaHeaders.ORIGINAL_TOPIC) topic: String,
        @Header(KafkaHeaders.ORIGINAL_PARTITION) partitionId: Int,
        @Header(KafkaHeaders.ORIGINAL_OFFSET) offset: Long,
        @Header(KafkaHeaders.EXCEPTION_MESSAGE) message: String,
        @Header(KafkaHeaders.GROUP_ID) groupId: String
    ) {
        log.info("topic = " + topic)
        log.info("partitionId = " + partitionId)
        log.info("offset = " + offset)
        log.info("message = " + message)
        log.info("groupId = " + groupId)
        log.info(record.value())
        log.info("!!!")
    }
}