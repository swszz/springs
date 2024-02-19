package com.swszz.rediscircuitbreaker.configuration

import com.swszz.rediscircuitbreaker.handler.CircuitBreakerCacheErrorHandler
import org.springframework.cache.annotation.CachingConfigurer
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.interceptor.CacheErrorHandler
import org.springframework.context.annotation.Configuration

@Configuration
@EnableCaching
internal class CacheConfiguration : CachingConfigurer {
    override fun errorHandler(): CacheErrorHandler {
        return CircuitBreakerCacheErrorHandler()
    }
}