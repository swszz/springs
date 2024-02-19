package com.swszz.rediscircuitbreaker.service

import com.swszz.rediscircuitbreaker.model.Post
import com.swszz.rediscircuitbreaker.repository.PostRepositoryWithCircuitBreaker
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class PostService(
    private val postRepositoryWithCircuitBreaker: PostRepositoryWithCircuitBreaker,
) {

    @Transactional
    fun savePostWithCircuitBreaker(
        post: Post
    ): Post {
        return postRepositoryWithCircuitBreaker.savePost(post = post)
    }

    @Transactional(readOnly = true)
    fun findPostById(
        id: Long
    ): Post {
        return postRepositoryWithCircuitBreaker.findPostById(id = id)
    }
}