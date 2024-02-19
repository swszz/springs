package com.swszz.cacingstrategy.repository

import com.swszz.cacingstrategy.constants.CacheNames
import com.swszz.cacingstrategy.mapper.toEntity
import com.swszz.cacingstrategy.mapper.toModel
import com.swszz.cacingstrategy.model.Post
import jakarta.persistence.EntityNotFoundException
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository


@Repository
internal class PostRepository(
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
        cacheNames = [CacheNames.POST],
        key = "#result.id",
        condition = "#result.deletedAt == null",
        unless = "#result.deletedAt != null"
    )
    @CacheEvict(
        cacheNames = [CacheNames.POST],
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
    @Cacheable(
        cacheNames = [CacheNames.POST],
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