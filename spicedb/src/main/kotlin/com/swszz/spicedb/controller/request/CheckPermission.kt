package com.swszz.spicedb.controller.request

import com.swszz.spicedb.PermissionTypes
import com.swszz.spicedb.model.PermissionPassport
import com.swszz.spicedb.model.PermissionRecipe

data class CheckPermission(
    val token: String,
    val passport: PermissionPassport,
    val recipe: PermissionRecipe,
    val type: PermissionTypes
)