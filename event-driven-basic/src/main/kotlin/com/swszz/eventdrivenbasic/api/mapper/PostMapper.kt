package com.swszz.eventdrivenbasic.api.mapper

import com.swszz.eventdrivenbasic.api.entity.PostEntity
import com.swszz.eventdrivenbasic.api.model.Post

internal fun Post.toEntity(): PostEntity {
    return PostEntity(id = this.id, content = this.content, deletedAt = this.deletedAt)
}

internal fun PostEntity.toModel(): Post {
    return Post(id = this.id, content = this.content, deletedAt = this.deletedAt)
}