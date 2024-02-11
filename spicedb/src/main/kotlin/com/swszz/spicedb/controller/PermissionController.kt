package com.swszz.spicedb.controller

import com.swszz.spicedb.controller.request.CheckPermission
import com.swszz.spicedb.controller.request.RegisterPermission
import com.swszz.spicedb.model.PermissionPassport
import com.swszz.spicedb.service.PermissionManagementService
import com.swszz.spicedb.service.SchemaManagementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/permission")
 class PermissionController(
    private val permissionManagementService: PermissionManagementService
) {
    @PostMapping
    fun register(
        @RequestBody payload: RegisterPermission
    ): ResponseEntity<String> {
        return ResponseEntity.ok(
            permissionManagementService.writePermission(
                passport = payload.passport,
                recipe = payload.recipe
            )
        )
    }

    @PostMapping("/check")
    fun check(
        @RequestBody payload: CheckPermission
    ): ResponseEntity<String> {
        return ResponseEntity.ok(
            permissionManagementService.checkPermission(
                token = payload.token,
                passport = payload.passport,
                recipe = payload.recipe,
                type = payload.type
            )
        )
    }
}