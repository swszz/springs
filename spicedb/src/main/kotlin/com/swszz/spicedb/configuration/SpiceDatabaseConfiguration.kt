package com.swszz.spicedb.configuration

import com.authzed.api.v1.PermissionsServiceGrpc
import com.authzed.grpcutil.BearerToken
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(SpiceDatabaseProperties::class)
internal class SpiceDatabaseConfiguration(
    private val properties: SpiceDatabaseProperties
) {
    @Bean
    fun authzedChannel(): ManagedChannel {
        return ManagedChannelBuilder
            .forAddress(properties.host, properties.port)
            .build()
    }

    @Bean
    fun authZedPermissionService(): PermissionsServiceGrpc.PermissionsServiceBlockingStub {
        return PermissionsServiceGrpc
            .newBlockingStub(authzedChannel())
            .withCallCredentials(BearerToken(properties.token))
    }
}