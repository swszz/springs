import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
    kotlin("plugin.jpa") version "1.9.20"
}

group = "com.swszz"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.github.serpro69:kotlin-faker:1.15.0")
    implementation("dev.openfga:openfga-sdk:0.3.0")
    runtimeOnly("mysql:mysql-connector-java:8.0.28")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}


allOpen {
    annotations(
        "jakarta.persistence.Entity",
        "jakarta.persistence.MappedSuperclass",
        "jakarta.persistence.Embeddable"
    )
}

//"TH","KR","KR","TW","","DE","HK","KR","TW","US","","KR","KR","CN","","","KR","","DK","","KR","CN","CN","KR","","","CN","","","","","","","KR","KR","KR","","CA","KR","FR","US","KR","KR","TR","","KR","","NO","","KR","NL","","KR","CN","SE","KR","KR","TH","KR","","","DE","","KR","US","US","","SE","","KR","KR","BG","DK","KR","GB","BR","CN","TW","","","","KR","KR","","","CN","","","KR","FR","","","KR","KR","KR","TW","KR","ES","","","","","KR","","","","RO","","KR","KR","","KR","US","","DE","","","","","","SE","KR","","KR","","DK","KR","KR","","BR","CN","CN","KR","","KR","KR","KR","KR","","FR","US","","DK","TW","KR","","","","CN","KR","KR","CN","","HU","","CN","CA","","KR","KR","","US","FR","KR","TW","DK","CN","KR","BR","","","KR","","","","KR","CN","","KR","CN","CN","CN","KR","","FR","KR","KR","","","","ES","CN","CN",""