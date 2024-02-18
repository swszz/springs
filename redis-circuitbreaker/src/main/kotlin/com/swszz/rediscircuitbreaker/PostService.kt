package com.swszz.rediscircuitbreaker

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
    fun findPostByIdWithCache(
        id: Long
    ): Post {
        return postRepositoryWithCircuitBreaker.findPostByIdWithCache(id = id)
    }
}