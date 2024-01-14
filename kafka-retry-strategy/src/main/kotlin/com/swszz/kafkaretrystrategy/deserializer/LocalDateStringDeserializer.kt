package com.swszz.kafkaretrystrategy.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import java.time.LocalDate

internal class LocalDateStringDeserializer : LocalDateDeserializer() {
    override fun deserialize(parser: JsonParser, context: DeserializationContext): LocalDate {
        return super._fromString(parser, context, parser.text)
    }
}
