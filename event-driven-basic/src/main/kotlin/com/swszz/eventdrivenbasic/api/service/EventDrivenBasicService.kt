package com.swszz.eventdrivenbasic.api.service

import com.swszz.eventdrivenbasic.api.model.Post
import com.swszz.eventdrivenbasic.api.repository.PostRepository
import com.swszz.eventdrivenbasic.kafka.constant.KafkaTopics
import com.swszz.eventdrivenbasic.kafka.publisher.EventPublisher
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class EventDrivenBasicService(
    private val eventPublisher: EventPublisher,
    private val postRepository: PostRepository,
) {

    @Transactional(value = "transactionManager")
    fun saveName(
        name: String
    ) {
        postRepository.savePost(Post(id = 0, content = "content", deletedAt = null))
        eventPublisher.publish(KafkaTopics.SAMPLE, name)
    }

    @Transactional(value = "kafkaTransactionManager")
    fun saveNameWithKafkaTransactionManager(
        name: String
    ) {
        postRepository.savePost(Post(id = 0, content = "content", deletedAt = null))
        eventPublisher.publish(KafkaTopics.SAMPLE, name)
    }
}