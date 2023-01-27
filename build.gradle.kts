plugins {
    java
}

group = "io.github.shiryu"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(18))
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

    compileOnly("org.projectlombok:lombok:1.18.24")
    compileOnly("org.jetbrains:annotations:24.0.0")

    annotationProcessor("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.jetbrains:annotations:24.0.0")
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }

    jar {
        archiveClassifier.set(null as String?)
        archiveBaseName.set(project.name)
        archiveVersion.set(project.version.toString())
    }

    javadoc {
        options.encoding = Charsets.UTF_8.name()
        (options as StandardJavadocDocletOptions).tags("todo")
    }

    val javadocJar by creating(Jar::class) {
        dependsOn("javadoc")
        archiveClassifier.set("javadoc")
        archiveBaseName.set(project.name)
        archiveVersion.set(project.version.toString())
        from(javadoc)
    }

    val sourcesJar by creating(Jar::class) {
        dependsOn("classes")
        archiveClassifier.set("sources")
        archiveBaseName.set(project.name)
        archiveVersion.set(project.version.toString())
        from(sourceSets["main"].allSource)
    }

    build {
        dependsOn(jar)
        dependsOn(sourcesJar)
        dependsOn(javadocJar)
    }
}