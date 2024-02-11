package com.swszz.spicedb.controller

import com.swszz.spicedb.service.SchemaManagementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/schema")
 class SchemaController(
    private val schemaManagementService: SchemaManagementService,
) {
    @PostMapping("/setup")
    fun setup(): ResponseEntity<Unit> {
        schemaManagementService.setup()
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun getAllSchema(): ResponseEntity<String> {
        return ResponseEntity.ok(
            schemaManagementService.getAllSchema()
        )
    }
}