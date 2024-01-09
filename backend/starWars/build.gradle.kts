plugins {
    id("com.android.library")
    kotlin("android")
}
@Suppress("UnstableApiUsage")
android {
    namespace = StarWarsClient.namespace("backend.starWars")
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
dependencies {
    implementation(Dependencies.Network.Gson.lib)
    implementation(project(":backend:utils"))
}