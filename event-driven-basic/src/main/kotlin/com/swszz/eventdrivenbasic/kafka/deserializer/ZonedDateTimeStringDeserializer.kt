package com.swszz.eventdrivenbasic.kafka.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

internal class ZonedDateTimeStringDeserializer : JsonDeserializer<ZonedDateTime>() {
    override fun deserialize(parser: JsonParser, context: DeserializationContext): ZonedDateTime {
        return parser.text.toLongOrNull()?.let {
            ZonedDateTime.ofInstant(Instant.ofEpochMilli(it), ZoneId.systemDefault())
        } ?: ZonedDateTime.parse(parser.text, DateTimeFormatter.ISO_DATE_TIME)
            .withZoneSameInstant(ZoneId.systemDefault())
    }
}