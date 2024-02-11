package com.swszz.spicedb.service

import com.authzed.api.v1.PermissionsServiceGrpc.PermissionsServiceBlockingStub
import org.springframework.stereotype.Service

@Service
internal class PermissionManagementService(
    private val permissionsServiceBlockingStub: PermissionsServiceBlockingStub
) {

    fun writePermission(

    ) {

    }
}