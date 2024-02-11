package com.swszz.spicedb.controller.request

import com.swszz.spicedb.model.PermissionPassport
import com.swszz.spicedb.model.PermissionRecipe

data class RegisterPermission(
    val passport: PermissionPassport,
    val recipe: PermissionRecipe
)