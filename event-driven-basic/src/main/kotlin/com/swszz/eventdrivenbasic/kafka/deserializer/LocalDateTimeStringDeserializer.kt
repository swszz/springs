package com.swszz.eventdrivenbasic.kafka.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

internal class LocalDateTimeStringDeserializer : LocalDateTimeDeserializer() {
    override fun deserialize(parser: JsonParser, context: DeserializationContext): LocalDateTime {
        return parser.text.toLongOrNull()?.let {
            LocalDateTime.ofInstant(Instant.ofEpochMilli(it), ZoneId.systemDefault())
        } ?: ZonedDateTime.parse(parser.text, DateTimeFormatter.ISO_DATE_TIME)
            .withZoneSameInstant(ZoneId.systemDefault())
            .toLocalDateTime()
    }
}
