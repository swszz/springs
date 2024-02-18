package com.swszz.rediscircuitbreaker

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
internal class PostController(
    private val postService: PostService
) {
    @GetMapping("test")
    fun test(): Post {
        return postService.savePostWithCircuitBreaker(
            post = Post(
                id = 0,
                content = "content!",
            )
        )
    }

    @GetMapping("test1")
    fun test(
        @RequestParam id: Long
    ): Post {
        return postService.findPostByIdWithCache(id = id)
    }
}