plugins {
    id("com.android.library")
    kotlin("android")
}
android {
    namespace = StarWarsClient.namespace("domain.basic")
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
    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingCompose)
    implementation(Dependencies.Core.Ktx.lib)

    implementation(project(":common:domain"))
}
