package com.swszz.kafkaretrystrategy.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDateTime
import java.time.ZoneId

internal class LocalDateTimeStringSerializer : JsonSerializer<LocalDateTime>() {
    override fun serialize(value: LocalDateTime, generator: JsonGenerator, provider: SerializerProvider) {
        generator.writeNumber(value.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
    }
}
