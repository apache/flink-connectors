plugins {
    `java-library`
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

version = "1.0.0-SNAPSHOT"

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}