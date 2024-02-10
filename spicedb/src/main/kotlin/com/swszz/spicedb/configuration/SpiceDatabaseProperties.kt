package com.swszz.spicedb.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spice")
class SpiceDatabaseProperties(
    val host: String,
    val port: Int,
    val token: String
)