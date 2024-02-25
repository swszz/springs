package com.swszz.eventdrivenbasic.kafka.specification

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.swszz.eventdrivenbasic.kafka.deserializer.LocalDateStringDeserializer
import com.swszz.eventdrivenbasic.kafka.deserializer.LocalDateTimeStringDeserializer
import com.swszz.eventdrivenbasic.kafka.deserializer.ZonedDateTimeStringDeserializer
import com.swszz.eventdrivenbasic.kafka.serializer.LocalDateStringSerializer
import com.swszz.eventdrivenbasic.kafka.serializer.LocalDateTimeStringSerializer
import com.swszz.eventdrivenbasic.kafka.serializer.ZonedDateTimeStringSerializer
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