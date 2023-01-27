plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "io.github.shiryu"
version = "1.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18))
    }
}

tasks{
    build{
        dependsOn(shadowJar)
    }
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
    mavenLocal()
}

dependencies{
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")

    implementation("com.github.cryptomorin:XSeries:9.2.0") { isTransitive = false }

    compileOnly("org.projectlombok:lombok:1.18.24")
    compileOnly("org.jetbrains:annotations:24.0.0")

    annotationProcessor("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.jetbrains:annotations:24.0.0")
}
