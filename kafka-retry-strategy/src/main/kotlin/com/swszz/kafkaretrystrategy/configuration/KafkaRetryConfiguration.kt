//package com.swszz.kafkaretrystrategy.configuration
//
//import com.swszz.kafkaretrystrategy.specification.DeadLetterHandler
//import com.swszz.kafkaretrystrategy.policy.KafkaPolicy
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
//import org.springframework.kafka.core.KafkaTemplate
//import org.springframework.kafka.retrytopic.RetryTopicConfiguration
//import org.springframework.kafka.retrytopic.RetryTopicConfigurationBuilder
//import org.springframework.kafka.retrytopic.TopicSuffixingStrategy
//import org.springframework.kafka.support.EndpointHandlerMethod
//
//
//@Configuration
//internal class KafkaRetryConfiguration {
//
//    @Bean
//    fun retryTopicConfiguration(
//        kafkaTemplate: KafkaTemplate<*, *>,
//        kafkaListenerContainerFactory: ConcurrentKafkaListenerContainerFactory<*, *>
//    ): RetryTopicConfiguration {
//        return RetryTopicConfigurationBuilder
//            .newInstance()
//            .autoCreateTopicsWith(
//                KafkaPolicy.DEFAULT_RETRY_TOPIC_PARTITION,
//                KafkaPolicy.DEFAULT_RETRY_TOPIC_REPLICATION_FACTOR
//            )
//            .maxAttempts(KafkaPolicy.DEFAULT_MAX_ATTEMPT)
//            .listenerFactory(kafkaListenerContainerFactory)
//            .setTopicSuffixingStrategy(TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE)
//            .dltHandlerMethod(EndpointHandlerMethod(DeadLetterHandler::class.java, "handle"))
//            .fixedBackOff(KafkaPolicy.DEFAULT_BACKOFF_INTERVAL)
//            .create(kafkaTemplate)
//    }
//}