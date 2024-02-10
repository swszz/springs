package com.swszz.spicedb

import com.authzed.api.v1.PermissionsServiceGrpc.PermissionsServiceBlockingStub
import org.springframework.stereotype.Service

@Service
internal class PermissionService(
    private val permissionsServiceBlockingStub: PermissionsServiceBlockingStub
)