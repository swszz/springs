package com.swszz.rediscircuitbreaker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
internal class RedisCircuitbreakerApplication

internal fun main(args: Array<String>) {
	runApplication<RedisCircuitbreakerApplication>(*args)
}
