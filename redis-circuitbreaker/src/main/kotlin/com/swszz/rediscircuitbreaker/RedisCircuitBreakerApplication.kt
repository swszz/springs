package com.swszz.rediscircuitbreaker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisCircuitbreakerApplication

fun main(args: Array<String>) {
	runApplication<RedisCircuitbreakerApplication>(*args)
}
