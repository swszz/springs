package com.swszz.cacingstrategy.controller

import com.swszz.cacingstrategy.model.Post
import com.swszz.cacingstrategy.service.PostService
import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime

@RestController
internal class PostController(
    private val postService: PostService,
) {
    @PostMapping("post")
    fun savePost(
        @RequestBody deleted: Boolean
    ): Post {
        return postService.savePost(
            post = Post(
                id = 1,
                content = "content!",
                deletedAt = when (deleted) {
                    true -> ZonedDateTime.now()
                    false -> null
                }
            )
        )
    }

    @GetMapping("post")
    fun findPostById(
        @RequestParam id: Long
    ): Post {
        return postService.findPostById(id = id)
    }
}