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
    maven("https://repo.panda-lang.org/releases")
    maven("https://repo.crazycrew.us/releases")
    maven("https://jitpack.io")
    maven("https://nexus.bencodez.com/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")

    mavenLocal()

    flatDir{
        dirs("libs")
    }
}

dependencies{
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")

    compileOnly("io.github.shiryu:spider:1.0")

    compileOnly("org.projectlombok:lombok:1.18.24")
    compileOnly("org.jetbrains:annotations:24.0.0")

    compileOnly("com.github.ben-manes.caffeine:caffeine:3.1.3")

    implementation("com.github.stefvanschie.inventoryframework:IF:0.10.8")
    implementation("dev.rollczi.litecommands:bukkit:2.8.4")

    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("com.badbones69.crazyenvoys", "crazyenvoys-api", "1.4.20.1")
    compileOnly("com.badbones69.crazycrates", "crazycrates-api", "1.11.14")
    compileOnly("com.bencodez:votingplugin:6.11.2")
    compileOnly("me.clip:placeholderapi:2.11.2")

    annotationProcessor("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.jetbrains:annotations:24.0.0")
}
