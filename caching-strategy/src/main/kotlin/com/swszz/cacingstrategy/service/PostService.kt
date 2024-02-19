package com.swszz.cacingstrategy.service

import com.swszz.cacingstrategy.model.Post
import com.swszz.cacingstrategy.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
internal class PostService(
    private val postRepository: PostRepository,
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
}