package com.swszz.spicedb.service

import com.authzed.api.v1.SchemaServiceGrpc.SchemaServiceBlockingStub
import com.authzed.api.v1.SchemaServiceOuterClass
import com.swszz.spicedb.Permissions
import com.swszz.spicedb.Relations
import com.swszz.spicedb.Resources
import com.swszz.spicedb.Subjects
import com.swszz.spicedb.request.WriteSchemaRequest
import org.springframework.stereotype.Service

@Service
internal class SchemaManagementService(
    private val schemaServiceBlockingStub: SchemaServiceBlockingStub
) {
    fun setup() {
        val subject = WriteSchemaRequest.Subject(Subjects.USER)
        val reader = WriteSchemaRequest.Relation(name = Relations.READER, subject = subject)
        val writer = WriteSchemaRequest.Relation(name = Relations.WRITER, subject = subject)
        val readPermission = WriteSchemaRequest.Permission(name = Permissions.READ, relations = setOf(reader, writer))
        val writePermission = WriteSchemaRequest.Permission(name = Permissions.WRITE, relations = setOf(writer))
        val request = WriteSchemaRequest.Request(
            subject = subject,
            resource = WriteSchemaRequest.Resource(
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