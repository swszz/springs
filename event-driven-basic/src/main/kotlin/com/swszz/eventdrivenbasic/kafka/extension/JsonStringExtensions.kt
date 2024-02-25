package com.swszz.eventdrivenbasic.kafka.extension

import com.fasterxml.jackson.core.type.TypeReference
import com.swszz.eventdrivenbasic.kafka.specification.ObjectMapperSpecifications.STRING_OBJECT_MAPPER


fun Any.toJsonString(): String =
    STRING_OBJECT_MAPPER.writeValueAsString(this)

internal fun String.toMutableMap() =
    STRING_OBJECT_MAPPER.readValue(this, object : TypeReference<MutableMap<String, Any>>() {})

@Suppress("UNCHECKED_CAST")
internal fun <T> String.toTypeObject(type: Class<T>): T =
    when (type) {
        String::class.java -> this as T
        else -> STRING_OBJECT_MAPPER.readValue(this, type)
    }
