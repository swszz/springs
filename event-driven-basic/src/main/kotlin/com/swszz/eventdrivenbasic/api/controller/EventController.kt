package com.swszz.eventdrivenbasic.api.controller

import com.swszz.eventdrivenbasic.api.service.EventDrivenBasicService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
internal class EventController(
    private val service: EventDrivenBasicService
) {
    @GetMapping("save-with-transaction-manager")
    fun saveName() {
        service.saveName(name = UUID.randomUUID().toString())
    }

    @GetMapping("save-with-kafka-transaction-manager")
    fun saveNameWithKafkaTransactionManager() {
        service.saveNameWithKafkaTransactionManager(name = UUID.randomUUID().toString())
    }
}