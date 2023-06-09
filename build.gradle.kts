import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.6.21"

    id("org.springframework.boot") version "2.7.6"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("kapt") version kotlinVersion
    kotlin("plugin.allopen") version kotlinVersion
    idea
}

group = "com.goofy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

object DependencyVersion {
    const val KOTLIN_LOGGING_VERSION = "3.0.0"
    const val LOGBACK_ENCODER_VERSION = "7.2"
    const val JACKSON_DATA_FORMAT_VERSION = "2.7.8"
}

dependencies {
    /** spring starter */
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    /** kotlin */
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    /** logger */
    implementation("io.github.microutils:kotlin-logging-jvm:${DependencyVersion.KOTLIN_LOGGING_VERSION}")
    implementation("net.logstash.logback:logstash-logback-encoder:${DependencyVersion.LOGBACK_ENCODER_VERSION}")

    /** test */
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }

    /** etc */
    developmentOnly("org.springframework.boot:spring-boot-devtools")
}

idea {
    module {
        val kaptMain = file("build/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Wrapper> {
    gradleVersion = "7.4.2"
}

tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}

java {
    withJavadocJar()
    withSourcesJar()
}
