// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Gradle.plugin)
        classpath(Dependencies.Kotlin.plugin)
        classpath(Dependencies.DaggerHilt.hiltAndroidGradlePlugin)

        kotlin(Dependencies.Json.classpathJsonDeps)
    }
}

allprojects {
    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
        kotlinOptions.freeCompilerArgs = kotlinOptions.freeCompilerArgs.toMutableList().apply {
            add("-Xjvm-default=all-compatibility")
        }.toList()
        kotlinOptions.jvmTarget = StarWarsClient.DefaultConfig.jvmTarget
    }
}

tasks.register("clean").configure {
    delete(rootProject.buildDir)
}