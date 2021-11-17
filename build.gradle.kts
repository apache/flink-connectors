plugins {
//    id("org.nosphere.apache.rat") version "0.5.2"
    `java-library`
    id("com.diffplug.spotless") version "6.0.0"
    checkstyle
}

group = "org.apache.flink.connectors"
version = "1.0.0-SNAPSHOT"

allprojects {
    apply(plugin = "java-library")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }

    repositories {
        mavenCentral()
    }
}

val isCiServer = System.getenv().containsKey("CI")
//if (!gradle.startParameter.isOffline && isCiServer) {
    configure<com.gradle.scan.plugin.BuildScanExtension> {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
//}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    java {
        googleJavaFormat("1.7").aosp()
    }
}

configure<CheckstyleExtension> {
}

subprojects {
    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}