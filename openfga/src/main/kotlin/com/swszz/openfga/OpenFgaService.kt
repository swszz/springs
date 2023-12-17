package com.swszz.openfga

import com.swszz.openfga.infrastructure.mysql.Student
import com.swszz.openfga.infrastructure.mysql.StudentGenerator
import com.swszz.openfga.infrastructure.mysql.StudentJpaRepository
import dev.openfga.sdk.api.client.OpenFgaClient
import dev.openfga.sdk.api.model.*
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class OpenFgaService(
    private val repository: StudentJpaRepository,
    private val client: OpenFgaClient
) {
    private val studentGenerator: StudentGenerator = StudentGenerator()


    @Transactional
    fun generate(size: Int) {
        val students: MutableList<Student> = mutableListOf()
        for (i: Int in 1..size) {
            students.add(studentGenerator.random())
        }
        repository.saveAll(students)
    }

    @EventListener(ApplicationStartedEvent::class)
    fun test2() {
        val request = WriteAuthorizationModelRequest()
            .schemaVersion("1.1")
            .typeDefinitions(
                listOf(
                    TypeDefinition().type("user").relations(mapOf()),
                    TypeDefinition()
                        .type("document")
                        .relations(
                            mapOf(
                                "writer" to Userset(),
                                "viewer" to Userset().union(
                                    Usersets()
                                        .child(
                                            listOf(
                                                Userset(),
                                                Userset().computedUserset(ObjectRelation().relation("writer"))
                                            )
                                        )
                                )
                            )
                        )
                        .metadata(
                            Metadata()
                                .relations(
                                    mapOf(
                                        "writer" to RelationMetadata().directlyRelatedUserTypes(
                                            listOf(RelationReference().type("user"))
                                        ),
                                        "viewer" to RelationMetadata().directlyRelatedUserTypes(
                                            listOf(RelationReference().type("user"))
                                        )
                                    )
                                )
                        )
                )
            )


//        val request: WriteAuthorizationModelRequest =
//            WriteAuthorizationModelRequest()
//                .schemaVersion(SCHEME_VERSION)
//                // type user
//                .addTypeDefinitionsItem(
//                    TypeDefinition()
//                        .type("user")
//                        .relations(emptyMap())
//                        .metadata(null)
//                )
//
//                //type group
//                //  relations
//                //    define member: [user]
//                .addTypeDefinitionsItem(
//                    TypeDefinition()
//                        .type("group")
//                        .putRelationsItem(
//                            "member", Userset()
//                                ._this("{}")
//                        ).metadata(
//                            Metadata()
//                                .putRelationsItem(
//                                    "member", RelationMetadata()
//                                        .addDirectlyRelatedUserTypesItem(
//                                            RelationReference()
//                                                .type("user")
//                                                .condition("")
//                                        )
//                                )
//                        )
//                ).conditions(emptyMap())


        println(request.toString())
        val a = client.readAuthorizationModels();
        val b = client.writeAuthorizationModel(request);


        while (!a.isDone) {
        }

        while (!b.isDone) {
        }
        println(b.get().toString())

        for (authorizationModel in a.get().authorizationModels) {
            println(authorizationModel)
        }
    }


    companion object {
        private const val SCHEME_VERSION: String = "1.1"
    }
}

