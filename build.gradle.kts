import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm") version "1.9.22" apply false
    kotlin("plugin.spring") version "1.9.22" apply false
    id("org.springframework.boot") version "3.2.3" apply false
    idea
}

allprojects {
    group = "com.onlyteo.framework"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        //plugin("java-library")
        plugin("kotlin")
        plugin("kotlin-spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    tasks {
        withType<JavaCompile> {
            sourceCompatibility = "21"
            targetCompatibility = "21"
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs += "-Xjsr305=strict"
                jvmTarget = "21"
            }
        }

        withType<Test> {
            useJUnitPlatform()
        }

        withType<Jar> {
            archiveClassifier = "" // Remove 'plain' file name suffix added by Spring Boot plugin
        }

        named<BootJar>("bootJar") {
            enabled = false
        }
    }
}
