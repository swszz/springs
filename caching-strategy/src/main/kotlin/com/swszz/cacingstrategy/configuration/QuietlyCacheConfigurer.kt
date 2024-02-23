package com.swszz.cacingstrategy.configuration

import com.swszz.cacingstrategy.handler.QuietlyCacheErrorHandler
import org.springframework.cache.annotation.CachingConfigurer
import org.springframework.cache.interceptor.CacheErrorHandler
import org.springframework.context.annotation.Configuration


@Configuration
internal class QuietlyCacheConfigurer : CachingConfigurer {
    override fun errorHandler(): CacheErrorHandler {
        return QuietlyCacheErrorHandler()
    }
}