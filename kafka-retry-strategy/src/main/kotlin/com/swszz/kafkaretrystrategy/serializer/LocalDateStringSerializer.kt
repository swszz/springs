package com.swszz.kafkaretrystrategy.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDate

internal class LocalDateStringSerializer : JsonSerializer<LocalDate>() {
    override fun serialize(value: LocalDate, generator: JsonGenerator, provider: SerializerProvider) {
        generator.writeString(value.toString())
    }
}
