package com.swszz.springs.oauth2.presentation.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("logincheck")
    fun test(
        @RequestParam accessToken: String,
        @RequestParam refreshToken: String,
    ) {
        println(accessToken)
        println(refreshToken)
        println("success!")
    }
}