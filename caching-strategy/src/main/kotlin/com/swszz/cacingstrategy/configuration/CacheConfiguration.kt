package com.swszz.cacingstrategy.configuration

import org.springframework.boot.autoconfigure.cache.CacheProperties
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.transaction.TransactionAwareCacheManagerProxy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair


@EnableCaching
@Configuration
@ConditionalOnBean(ResourceLoader::class, RedisConnectionFactory::class)
@EnableConfigurationProperties(CacheProperties::class)
internal class CacheConfiguration {
    @Bean
    fun cacheManager(
        resourceLoader: ResourceLoader,
        cacheProperties: CacheProperties,
        redisConnectionFactory: RedisConnectionFactory
    ): CacheManager {
        val redisCacheConfiguration: RedisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().apply {
            this.serializeValuesWith(SerializationPair.fromSerializer(JdkSerializationRedisSerializer(resourceLoader.classLoader)))

            cacheProperties.redis.timeToLive?.let { this.entryTtl(it) }
            cacheProperties.redis.keyPrefix?.let { this.prefixCacheNameWith(it) }

            if (cacheProperties.redis.isCacheNullValues.not()) {
                this.disableCachingNullValues()
            }
            if (cacheProperties.redis.isUseKeyPrefix.not()) {
                this.disableKeyPrefix()
            }
        }

        return TransactionAwareCacheManagerProxy(
            RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .build()
        ).apply {
            this.afterPropertiesSet()
        }
    }
}