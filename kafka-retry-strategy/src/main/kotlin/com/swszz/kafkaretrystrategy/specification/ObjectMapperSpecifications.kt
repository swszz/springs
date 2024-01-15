package com.swszz.kafkaretrystrategy.specification

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.swszz.kafkaretrystrategy.deserializer.LocalDateStringDeserializer
import com.swszz.kafkaretrystrategy.deserializer.LocalDateTimeStringDeserializer
import com.swszz.kafkaretrystrategy.deserializer.ZonedDateTimeStringDeserializer
import com.swszz.kafkaretrystrategy.serializer.LocalDateStringSerializer
import com.swszz.kafkaretrystrategy.serializer.LocalDateTimeStringSerializer
import com.swszz.kafkaretrystrategy.serializer.ZonedDateTimeStringSerializer
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime

object ObjectMapperSpecifications {
    val STRING_OBJECT_MAPPER: ObjectMapper =
        jacksonObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .registerModule(
                SimpleModule()
                    .addSerializer(LocalDateTime::class.java, LocalDateTimeStringSerializer())
                    .addDeserializer(LocalDateTime::class.java, LocalDateTimeStringDeserializer())
                    .addSerializer(LocalDate::class.java, LocalDateStringSerializer())
                    .addDeserializer(LocalDate::class.java, LocalDateStringDeserializer())
                    .addSerializer(ZonedDateTime::class.java, ZonedDateTimeStringSerializer())
                    .addDeserializer(ZonedDateTime::class.java, ZonedDateTimeStringDeserializer())
            ).enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
}