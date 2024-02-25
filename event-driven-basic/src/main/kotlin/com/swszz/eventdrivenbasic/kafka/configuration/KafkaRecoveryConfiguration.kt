package com.swszz.eventdrivenbasic.kafka.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.listener.CommonErrorHandler
import org.springframework.kafka.listener.ConsumerRecordRecoverer
import org.springframework.kafka.listener.DefaultErrorHandler
import org.springframework.util.backoff.BackOff
import org.springframework.util.backoff.FixedBackOff


@Configuration
internal class KafkaRecoveryConfiguration {
    @Bean
    fun customErrorHandler(): CommonErrorHandler {
        return CustomErrorHandler({ record, exception -> exception.printStackTrace() }, FixedBackOff(0, 0))
    }

    /**
     * record, exception을 사용하는 Recover 로직을 설정한다.
     * 주로 slack 알람과 같은 Detection 기능을 추가한다.
     */
    internal class CustomErrorHandler(
        recoverer: ConsumerRecordRecoverer,
        backOff: BackOff
    ) : DefaultErrorHandler(recoverer, backOff)
}
