package com.swszz.rediscircuitbreaker.repository

import com.swszz.rediscircuitbreaker.constants.CacheNames
import com.swszz.rediscircuitbreaker.constants.CircuitNames
import com.swszz.rediscircuitbreaker.mapper.toEntity
import com.swszz.rediscircuitbreaker.mapper.toModel
import com.swszz.rediscircuitbreaker.model.Post
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import jakarta.persistence.EntityNotFoundException
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository


@Repository
internal class PostRepositoryWithCircuitBreaker(
    private val postJpaRepository: PostJpaRepository,
) {

    /**
     * Entity를 변경하는 메소드의 경우 상황에 따라 @CachePut과 @CacheEvict를 적용한다.<br>
     *
     * - Cache를 갱신할 필요가 있을 때는 @CachePut을 적용한다.<br>
     * - Cache를 삭제할 필요가 있을 때는 @CacheEvict를 적용한다.<br>
     *
     * @see org.springframework.cache.annotation.CachePut
     * @see org.springframework.cache.annotation.CacheEvict
     */
    @CachePut(
        cacheNames = [CacheNames.REDIS_CIRCUIT_BREAKER],
        key = "#result.id",
        condition = "#result.deletedAt == null",
        unless = "#result.deletedAt != null"
    )
    @CacheEvict(
        cacheNames = [CacheNames.REDIS_CIRCUIT_BREAKER],
        key = "#post.id"
    )
    fun savePost(
        post: Post
    ): Post {
        return postJpaRepository.save(post.toEntity()).toModel()
    }

    /**
     * Entity를 조회하는 메소드의 경우 상황에 따라 @Cacheable을 적용한다.<br>
     *
     * - read-only로 사용하고 싶을 때는 unless = "true" 옵션을 추가한다.<br>
     *
     * @see org.springframework.cache.annotation.Cacheable
     */
    @CircuitBreaker(
        name = CircuitNames.SAVE_POST,
        fallbackMethod = "savePostFallback"
    )
    @Cacheable(
        cacheNames = [CacheNames.REDIS_CIRCUIT_BREAKER],
        key = "#id",
        unless = "true"
    )
    fun findPostById(
        id: Long
    ): Post {
        return postJpaRepository.findById(id)
            .orElseThrow { EntityNotFoundException() }
            .toModel()
    }
}