package com.swszz.cacingstrategy.mapper

import com.swszz.cacingstrategy.entity.PostEntity
import com.swszz.cacingstrategy.model.Post

internal fun Post.toEntity(): PostEntity {
    return PostEntity(id = this.id, content = this.content, deletedAt = this.deletedAt)
}

internal fun PostEntity.toModel(): Post {
    return Post(id = this.id, content = this.content, deletedAt = this.deletedAt)
}