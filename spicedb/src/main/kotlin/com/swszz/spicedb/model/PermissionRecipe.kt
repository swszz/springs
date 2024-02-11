package com.swszz.spicedb.model

import com.swszz.spicedb.RelationTypes

class PermissionRecipe(
    val resource: Resource,
    val relationType: RelationTypes
)