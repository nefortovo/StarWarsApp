plugins {
    id("com.android.library")
    kotlin("android")
}
@Suppress("UnstableApiUsage")
android {
    namespace = StarWarsClient.namespace("common.domain")
    compileSdk = StarWarsClient.DefaultConfig.compileSdk
    defaultConfig {
        minSdk = StarWarsClient.DefaultConfig.minSdk
        targetSdk = StarWarsClient.DefaultConfig.targetSdk
    }
    compileOptions {
        sourceCompatibility = StarWarsClient.DefaultConfig.jVersion
        targetCompatibility = StarWarsClient.DefaultConfig.jVersion
    }
}