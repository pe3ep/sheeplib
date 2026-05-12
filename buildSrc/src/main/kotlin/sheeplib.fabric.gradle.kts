import org.gradle.accessors.dm.LibrariesForLibs
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
    id("net.fabricmc.fabric-loom")
    kotlin("jvm")
}

base {
    archivesName = "sheeplib-${project.name}"
}

// https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
internal val Project.libs get() = project.extensions.getByName("libs") as LibrariesForLibs

kotlin {
    explicitApi()
    jvmToolchain(25)
}

tasks {
    named<KotlinCompilationTask<*>>("compileKotlin") {
        compilerOptions {
            freeCompilerArgs.add("-Xjvm-default=all")
        }
    }

    processResources {
        inputs.property("version", project.version)
        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }
}


repositories {
    mavenCentral()
}

dependencies {
    minecraft(libs.minecraft)

    implementation(libs.fabric.api)
    implementation(libs.fabric.loader)
    implementation(libs.fabric.kotlin)
}
