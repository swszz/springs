package com.swszz.cacingstrategy.service

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TestCompoent {

    @KafkaListener(groupId = "34534534", topics = ["sample2277"], autoStartup = "true")
    fun test(event: String) {
        println("@@@@")
        println(event)
        println("@@@@")
    }
}