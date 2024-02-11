package com.swszz.spicedb.service

import com.authzed.api.v1.SchemaServiceGrpc.SchemaServiceBlockingStub
import com.authzed.api.v1.SchemaServiceOuterClass
import com.swszz.spicedb.Permissions
import com.swszz.spicedb.Relations
import com.swszz.spicedb.Resources
import com.swszz.spicedb.Roles
import com.swszz.spicedb.request.AuthZedWriteSchemaRequest
import org.springframework.stereotype.Service

@Service
internal class SchemaManagementService(
    private val schemaServiceBlockingStub: SchemaServiceBlockingStub
) {
    fun setup() {
        val role = AuthZedWriteSchemaRequest.Role(Roles.USER)
        val reader = AuthZedWriteSchemaRequest.Relation(name = Relations.READER, role = role)
        val writer = AuthZedWriteSchemaRequest.Relation(name = Relations.WRITER, role = role)
        val readPermission =
            AuthZedWriteSchemaRequest.Permission(name = Permissions.READ, relations = setOf(reader, writer))
        val writePermission = AuthZedWriteSchemaRequest.Permission(name = Permissions.WRITE, relations = setOf(writer))
        val request = AuthZedWriteSchemaRequest.Request(
            role = role,
            resource = AuthZedWriteSchemaRequest.Resource(
                name = Resources.DOCUMENT,
                relations = setOf(reader, writer),
                permissions = setOf(readPermission, writePermission)
            )
        )

        schemaServiceBlockingStub.writeSchema(
            SchemaServiceOuterClass.WriteSchemaRequest.newBuilder()
                .setSchema(request.toRequestBody())
                .build()
        )
    }

    fun getAllSchema(): String {
        return schemaServiceBlockingStub.readSchema(
            SchemaServiceOuterClass.ReadSchemaRequest.newBuilder()
                .build()
        ).schemaText
    }
}