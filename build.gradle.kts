import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.0"
    kotlin("plugin.serialization") version "1.5.0"
}

group = "me.dzikimlecz"
version = "1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    jcenter()
}

dependencies {
    implementation(group = "com.fasterxml.jackson.core", name = "jackson-annotations", version = "2.4.3")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-serialization-json", version = "1.0.1")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib")
    testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api", version = "5.7.0")
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.7.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
