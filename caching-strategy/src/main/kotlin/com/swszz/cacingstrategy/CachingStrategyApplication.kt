package com.swszz.cacingstrategy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
internal class CachingStrategyApplication

internal fun main(args: Array<String>) {
    runApplication<CachingStrategyApplication>(*args)
}
