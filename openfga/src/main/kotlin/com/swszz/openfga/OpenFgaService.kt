package com.swszz.openfga

import com.swszz.openfga.infrastructure.mysql.Student
import com.swszz.openfga.infrastructure.mysql.StudentGenerator
import com.swszz.openfga.infrastructure.mysql.StudentJpaRepository
import dev.openfga.sdk.api.client.OpenFgaClient
import dev.openfga.sdk.api.client.model.ClientCreateStoreResponse
import dev.openfga.sdk.api.model.CreateStoreRequest
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.CompletableFuture

@Service
class OpenFgaService(
    private val repository: StudentJpaRepository,
    private val client: OpenFgaClient
) {
    private val studentGenerator: StudentGenerator = StudentGenerator()

    @Transactional
    fun generate(size: Int) {
        val students: MutableList<Student> = mutableListOf()
        for (i: Int in 1..size) {
            students.add(studentGenerator.random())
        }
        repository.saveAll(students)
    }

    @EventListener(ApplicationStartedEvent::class)
    fun test() {
        val response: CompletableFuture<ClientCreateStoreResponse> = client.createStore(
            CreateStoreRequest()
                .name("testStore")
        )

        while (!response.isDone) {
            ;
        }

        println(response)
    }

}