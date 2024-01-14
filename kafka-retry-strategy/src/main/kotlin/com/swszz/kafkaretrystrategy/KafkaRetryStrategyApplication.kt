package com.swszz.kafkaretrystrategy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaRetryStrategyApplication

fun main(args: Array<String>) {
    runApplication<KafkaRetryStrategyApplication>(*args)
}
