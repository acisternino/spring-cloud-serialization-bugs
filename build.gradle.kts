plugins {
    java
    id("org.springframework.boot") version "3.3.2"
}

group = "com.example"

version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

val springBootVersion by extra("3.3.2")

// val springCloudVersion by extra("2023.0.2")
val springCloudVersion by extra("2023.0.3")

dependencies {
    implementation(platform("org.springframework.boot:spring-boot-dependencies:${springBootVersion}"))
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"))
    implementation("org.springframework.cloud:spring-cloud-starter-stream-rabbit")
}
