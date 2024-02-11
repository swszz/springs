package com.swszz.spicedb.service

import com.authzed.api.v1.SchemaServiceGrpc.SchemaServiceBlockingStub
import com.authzed.api.v1.SchemaServiceOuterClass
import com.swszz.spicedb.PermissionTypes
import com.swszz.spicedb.RelationTypes
import com.swszz.spicedb.ResourceTypes
import com.swszz.spicedb.SubjectTypes
import com.swszz.spicedb.request.WriteSchemaRequest
import org.springframework.stereotype.Service

@Service
class SchemaManagementService(
    private val schemaServiceBlockingStub: SchemaServiceBlockingStub
) {
    fun setup() {
        val subject = WriteSchemaRequest.Subject(SubjectTypes.USER.value)
        val reader = WriteSchemaRequest.Relation(name = RelationTypes.READER.value, subject = subject)
        val writer = WriteSchemaRequest.Relation(name = RelationTypes.WRITER.value, subject = subject)
        val readPermission =
            WriteSchemaRequest.Permission(name = PermissionTypes.READ.value, relations = setOf(reader, writer))
        val writePermission =
            WriteSchemaRequest.Permission(name = PermissionTypes.WRITE.value, relations = setOf(writer))
        val request = WriteSchemaRequest.Request(
            subject = subject,
            resource = WriteSchemaRequest.Resource(
                name = ResourceTypes.DOCUMENT.value,
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