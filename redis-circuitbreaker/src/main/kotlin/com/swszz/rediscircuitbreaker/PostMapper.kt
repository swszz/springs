package com.swszz.rediscircuitbreaker

internal fun Post.toEntity(): PostEntity {
    return PostEntity(id = this.id, content = this.content)
}

internal fun PostEntity.toModel(): Post {
    return Post(id = this.id, content = this.content)
}