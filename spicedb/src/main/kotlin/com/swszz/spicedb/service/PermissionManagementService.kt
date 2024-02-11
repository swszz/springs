package com.swszz.spicedb.service

import com.authzed.api.v1.Core.*
import com.authzed.api.v1.PermissionService.*
import com.authzed.api.v1.PermissionsServiceGrpc.PermissionsServiceBlockingStub
import com.swszz.spicedb.PermissionTypes
import com.swszz.spicedb.model.PermissionPassport
import com.swszz.spicedb.model.PermissionRecipe
import org.springframework.stereotype.Service


@Service
class PermissionManagementService(
    private val permissionsServiceBlockingStub: PermissionsServiceBlockingStub
) {
    fun writePermission(
        passport: PermissionPassport,
        recipe: PermissionRecipe
    ): String {

        /**
         * 권한 부여 리소스 (Document와 같음)
         */
        val resourceReference: ObjectReference = ObjectReference.newBuilder()
            .setObjectType(recipe.resource.type.value)
            .setObjectId(recipe.resource.id)
            .build()

        /**
         * 권한을 부여 받을 대상 (User와 같음)
         */
        val subjectReference: SubjectReference = SubjectReference.newBuilder()
            .setObject(
                ObjectReference.newBuilder()
                    .setObjectType(passport.subject.type.value)
                    .setObjectId(passport.subject.id)
                    .build()
            ).build()

        /**
         * 리소스에 대해 대상에게 부여하고자 하는 관계 (Writer, Reader와 같음)
         */
        val relationship: Relationship = Relationship.newBuilder()
            .setResource(resourceReference)
            .setRelation(recipe.relationType.value)
            .setSubject(subjectReference)
            .build()

        /**
         * 관계 업데이트 요청 객체 생성
         */
        val relationshipUpdate: RelationshipUpdate = RelationshipUpdate.newBuilder()
            .setOperation(RelationshipUpdate.Operation.OPERATION_CREATE)
            .setRelationship(relationship)
            .build()

        /**
         * 요청
         */
        val request: WriteRelationshipsRequest =
            WriteRelationshipsRequest.newBuilder()
                .addUpdates(relationshipUpdate)
                .build()

        /**
         * 요청 및 토큰 반환
         */
        return permissionsServiceBlockingStub.writeRelationships(request).writtenAt.token
    }

    fun checkPermission(
        token: String,
        passport: PermissionPassport,
        recipe: PermissionRecipe,
        type: PermissionTypes
    ): String {

        /**
         * 토큰 변환
         */
        val zedToken: ZedToken = ZedToken.newBuilder()
            .setToken(token)
            .build()

        /**
         * API 기준 일관 처리를 위한 토큰 셋업
         */
        val consistency: Consistency = Consistency.newBuilder()
            .setAtLeastAsFresh(zedToken)
            .build()

        /**
         * 권한 부여 리소스 (Document와 같음)
         */
        val resourceReference: ObjectReference = ObjectReference.newBuilder()
            .setObjectType(recipe.resource.type.value)
            .setObjectId(recipe.resource.id)
            .build()

        /**
         * 권한을 부여 받을 대상 (User와 같음)
         */
        val subjectReference: SubjectReference = SubjectReference.newBuilder()
            .setObject(
                ObjectReference.newBuilder()
                    .setObjectType(passport.subject.type.value)
                    .setObjectId(passport.subject.id)
                    .build()
            ).build()

        return permissionsServiceBlockingStub.checkPermission(
            CheckPermissionRequest.newBuilder()
                .setConsistency(consistency)
                .setResource(resourceReference)
                .setSubject(subjectReference)
                .setPermission(type.value)
                .build()
        ).permissionship.name
    }
}