package com.swszz.spicedb

import com.authzed.api.v1.SchemaServiceGrpc
import com.authzed.api.v1.SchemaServiceOuterClass
import com.swszz.spicedb.request.schema.AuthZedWriteSchema
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
internal class SchemaService(
    private val authZedSchemaService: SchemaServiceGrpc.SchemaServiceBlockingStub,
) {
    @PostConstruct
    private fun setup() {
        val role = AuthZedWriteSchema.Role(Roles.USER)
        val reader = AuthZedWriteSchema.Relation(name = Relations.READER, role = role)
        val writer = AuthZedWriteSchema.Relation(name = Relations.WRITER, role = role)
        val readPermission = AuthZedWriteSchema.Permission(name = Permissions.READ, relations = setOf(reader, writer))
        val writePermission = AuthZedWriteSchema.Permission(name = Permissions.WRITE, relations = setOf(writer))
        val request = AuthZedWriteSchema.Request(
            role = role,
            resource = AuthZedWriteSchema.Resource(
                name = Resources.DOCUMENT,
                relations = setOf(reader, writer),
                permissions = setOf(readPermission, writePermission)
            )
        )

        authZedSchemaService.writeSchema(
            SchemaServiceOuterClass.WriteSchemaRequest.newBuilder()
                .setSchema(request.toRequestBody())
                .build()
        )
    }
}