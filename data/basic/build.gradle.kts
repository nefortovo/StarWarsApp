plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}
android {
    namespace = StarWarsClient.namespace("data.basic")
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
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingCompose)

    implementation(project(":domain:basic"))
    implementation(project(":common:domain"))

    implementation(Dependencies.Room.roomRuntime)
    implementation(Dependencies.Room.roomKtx)
    annotationProcessor(Dependencies.Room.annotationProcessor)
    kapt(Dependencies.Room.roomKapt)
}
