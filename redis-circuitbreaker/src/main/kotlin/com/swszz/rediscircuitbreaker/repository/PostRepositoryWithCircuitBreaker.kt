package com.swszz.rediscircuitbreaker.repository

import com.swszz.rediscircuitbreaker.*
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import jakarta.persistence.EntityNotFoundException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository


@Repository
internal class PostRepositoryWithCircuitBreaker(
    private val postJpaRepository: PostJpaRepository,
) {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    /**
     * Entity를 변경하는 메소드의 경우 상황에 따라 @CachePut과 @CacheEvict를 적용한다.<br>
     *
     * - Cache를 갱신할 필요가 있을 때는 @CachePut을 적용한다.<br>
     * - Cache를 삭제할 필요가 있을 때는 @CacheEvict를 적용한다.<br>
     *
     * @see org.springframework.cache.annotation.CachePut
     * @see org.springframework.cache.annotation.CacheEvict
     */
    @CircuitBreaker(
        name = CircuitNames.SAVE_POST,
        fallbackMethod = "savePostFallback"
    )
    @CachePut(
        cacheNames = [CacheNames.REDIS_CIRCUIT_BREAKER],
        key = "#post.id",
        condition = "#post.deletedAt == null",
    )
    @CacheEvict(
        cacheNames = [CacheNames.REDIS_CIRCUIT_BREAKER],
        key = "#post.id",
        condition = "#post.deletedAt != null"
    )
    fun savePost(
        post: Post
    ): Post {
        return postJpaRepository.save(post.toEntity()).toModel()
    }

    private fun savePostFallback(
        post: Post,
        throwable: Throwable
    ): Post {
        logger.warn("exception message : ${throwable.message}")
        return postJpaRepository.save(post.toEntity()).toModel()
    }

    /**
     * Entity를 조회하는 메소드의 경우 상황에 따라 @Cacheable을 적용한다.<br>
     *
     * - read-only로 사용하고 싶을 때는 unless = "true" 옵션을 추가한다.<br>
     *
     * @see org.springframework.cache.annotation.Cacheable
     */
    @Cacheable(
        cacheNames = [CacheNames.REDIS_CIRCUIT_BREAKER],
        key = "#id",
        unless = "true"
    )
    fun findPostByIdWithCache(
        id: Long
    ): Post {
        return postJpaRepository.findById(id)
            .orElseThrow { EntityNotFoundException() }
            .toModel()
    }
}