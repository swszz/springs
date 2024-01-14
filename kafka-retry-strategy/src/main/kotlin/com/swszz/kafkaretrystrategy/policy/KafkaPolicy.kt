package com.swszz.kafkaretrystrategy.policy

internal object KafkaPolicy {
    const val DEFAULT_TIMEOUT_SEC: Long = 3
    const val DEFAULT_RETRY_TOPIC_PARTITION: Int = 1
    const val DEFAULT_RETRY_TOPIC_REPLICATION_FACTOR: Short = 1
    const val DEFAULT_MAX_ATTEMPT: Int = 1
    const val DEFAULT_BACKOFF_INTERVAL: Int = 500
}