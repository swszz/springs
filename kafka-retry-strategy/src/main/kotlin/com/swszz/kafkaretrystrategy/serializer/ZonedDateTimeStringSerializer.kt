package com.swszz.kafkaretrystrategy.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.ZonedDateTime

internal class ZonedDateTimeStringSerializer : JsonSerializer<ZonedDateTime>() {
    override fun serialize(value: ZonedDateTime, generator: JsonGenerator, provider: SerializerProvider) {
        generator.writeString(value.toString())
    }
}