package com.swszz.spicedb.request


 class WriteSchemaRequest {

    interface Schema {
        fun toRequestBody(): String
    }

     class Request(
        val subject: Subject,
        val resource: Resource
    ) : Schema {
        override fun toRequestBody(): String {
            return subject.toRequestBody() + "\n" +
                    resource.toRequestBody()
        }
    }

     class Subject(
        val name: String
    ) : Schema {
        override fun toRequestBody(): String {
            return "definition $name {}"
        }
    }

     class Resource(
        val name: String,
        val relations: Set<Relation>,
        val permissions: Set<Permission>
    ) : Schema {
        override fun toRequestBody(): String {
            return "definition $name { \n" +
                    relations.joinToString(
                        prefix = "\t",
                        separator = "\n\t"
                    ) { it.toRequestBody() } +
                    "\n" +
                    permissions.joinToString(
                        prefix = "\t",
                        separator = "\n\t"
                    ) { it.toRequestBody() } +
                    "\n}"
        }
    }

     class Relation(
        val name: String,
        val subject: Subject,
    ) : Schema {
        override fun toRequestBody(): String {
            return "relation $name: ${subject.name}"
        }

    }

     class Permission(
        private val name: String,
        private val relations: Set<Relation>,
    ) : Schema {
        override fun toRequestBody(): String {
            return "permission $name = ${relations.joinToString(separator = " + ") { it.name }}"
        }
    }
}
