package com.swszz.rediscircuitbreaker.handler

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.Cache
import org.springframework.cache.interceptor.CacheErrorHandler
import java.lang.RuntimeException

internal class CircuitBreakerCacheErrorHandler : CacheErrorHandler {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    override fun handleCacheGetError(exception: RuntimeException, cache: Cache, key: Any) {
        logger.warn("Cache get failure. exception : ${exception.javaClass}, name : ${cache.name}, key : $key")
    }

    override fun handleCachePutError(exception: RuntimeException, cache: Cache, key: Any, value: Any?) {
        logger.warn("Cache put failure. exception : ${exception.javaClass}, name : ${cache.name}, key : $key")
    }

    override fun handleCacheEvictError(exception: RuntimeException, cache: Cache, key: Any) {
        logger.warn("Cache evict failure. exception : ${exception.javaClass}, name : ${cache.name}, key : $key")
    }

    override fun handleCacheClearError(exception: RuntimeException, cache: Cache) {
        logger.warn("Cache clear failure. exception : ${exception.javaClass}, name : ${cache.name}")
    }
}