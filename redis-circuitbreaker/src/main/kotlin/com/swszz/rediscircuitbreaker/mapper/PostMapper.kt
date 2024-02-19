package com.swszz.rediscircuitbreaker.mapper

import com.swszz.rediscircuitbreaker.entity.PostEntity
import com.swszz.rediscircuitbreaker.model.Post

internal fun Post.toEntity(): PostEntity {
    return PostEntity(id = this.id, content = this.content)
}

internal fun PostEntity.toModel(): Post {
    return Post(id = this.id, content = this.content)
}