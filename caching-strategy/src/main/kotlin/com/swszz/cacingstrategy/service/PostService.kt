package com.swszz.cacingstrategy.service

import com.swszz.cacingstrategy.model.Post
import com.swszz.cacingstrategy.repository.PostRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
internal class PostService(
    private val postRepository: PostRepository,
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    @Transactional
    fun savePost(
        post: Post
    ): Post {
        return postRepository.savePost(post = post)
    }

    @Transactional(readOnly = true)
    fun findPostById(
        id: Long
    ): Post {
        return postRepository.findPostById(id = id)
    }

    @Transactional("kafkaTransactionManager")
    fun sendWithThrow() {
        postRepository.savePost(Post(0, "1", null))
        kafkaTemplate.send("sample2277", UUID.randomUUID().toString())
    }

    @Transactional("transactionManager")
    fun sendWithoutThrow() {
        println("sendWithoutThrow")
        postRepository.savePost(Post(0, "1", null))
        kafkaTemplate.send("sample2277", UUID.randomUUID().toString())
    }
}