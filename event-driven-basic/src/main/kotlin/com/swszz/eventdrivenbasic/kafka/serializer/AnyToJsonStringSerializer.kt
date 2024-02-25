package com.swszz.eventdrivenbasic.kafka.serializer

import com.swszz.eventdrivenbasic.kafka.extension.toJsonString
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer
import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets

internal class AnyToJsonStringSerializer : Serializer<Any> {

    private var encoding = StandardCharsets.UTF_8.name()
    override fun configure(configs: Map<String, *>, isKey: Boolean) {
        val propertyName: String =
            when (isKey) {
                true -> "key.serializer.encoding"
                else -> "value.serializer.encoding"
            }
        var encodingValue = configs[propertyName]
        if (encodingValue == null) encodingValue = configs["serializer.encoding"]
        if (encodingValue is String) encoding = encodingValue
    }

    @Suppress("UNREACHABLE_CODE")
    override fun serialize(topic: String, data: Any): ByteArray {
        return try {
            return data.toJsonString().toByteArray(charset(encoding))
        } catch (e: UnsupportedEncodingException) {
            throw SerializationException("Error when serializing string to byte[] due to unsupported encoding $encoding")
        }
    }
}