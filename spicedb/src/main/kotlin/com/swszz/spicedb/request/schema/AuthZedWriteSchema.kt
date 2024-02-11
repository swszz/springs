package com.swszz.spicedb.request.schema


internal class AuthZedWriteSchema {

    interface Schema {
        fun toRequestBody(): String
    }

    internal class Request(
        val role: Role,
        val resource: Resource
    ) : Schema {
        override fun toRequestBody(): String {
            return role.toRequestBody() + "\n" +
                    resource.toRequestBody()
        }
    }

    internal class Role(
        val name: String
    ) : Schema {
        override fun toRequestBody(): String {
            return "definition $name {}"
        }
    }

    internal class Resource(
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

    internal class Relation(
        val name: String,
        val role: Role,
    ) : Schema {
        override fun toRequestBody(): String {
            return "relation $name: ${role.name}"
        }

    }

    internal class Permission(
        private val name: String,
        private val relations: Set<Relation>,
    ) : Schema {
        override fun toRequestBody(): String {
            return "permission $name = ${relations.joinToString(separator = " + ") { it.name }}"
        }
    }
}
