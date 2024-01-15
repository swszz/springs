package com.swszz.kafkaretrystrategy.specification

import io.github.resilience4j.core.IntervalFunction
import io.github.resilience4j.retry.Retry
import io.github.resilience4j.retry.RetryConfig
import io.github.resilience4j.retry.RetryRegistry

internal object RetryHandler {
    /**
     * 코드 레벨에서 retry 로직을 구현한다.
     */
    fun execute(runnable: Runnable) {
        Retry.decorateCallable(DEFAULT_RETRY) { runnable.run() }.call()
    }

    private val DEFAULT_RETRY =
        RetryConfig.custom<Any>()
            .maxAttempts(3)
            .intervalFunction(IntervalFunction.ofExponentialBackoff(300))
            .build()
            .let(RetryRegistry::of)
            .retry("retry-handler")
}