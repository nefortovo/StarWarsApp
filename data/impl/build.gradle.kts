plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}
android {
    namespace = StarWarsClient.namespace("data.impl")
    compileSdk = StarWarsClient.DefaultConfig.compileSdk
    defaultConfig {
        minSdk = StarWarsClient.DefaultConfig.minSdk
        targetSdk = StarWarsClient.DefaultConfig.targetSdk
    }
    compileOptions {
        sourceCompatibility = StarWarsClient.DefaultConfig.jVersion
        targetCompatibility = StarWarsClient.DefaultConfig.jVersion
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Network.Retrofit.lib)
    implementation(Dependencies.Network.Gson.lib)
    implementation(Dependencies.Network.Logging.lib)
    implementation(Dependencies.Coroutines.lib)
    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingCompose)

    implementation(Dependencies.DaggerHilt.hilt)
    kapt(Dependencies.DaggerHilt.daggerHiltCompiler)

    implementation(Dependencies.Json.lib)
    implementation(Dependencies.Json.serializationConverterLib)
    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingCompose)
    implementation(Dependencies.DaggerHilt.hilt)

    api(project(":data:basic"))

    implementation(project(":backend:starWars"))
    implementation(project(":backend:utils"))
    implementation(project(":common:domain"))
    implementation(project(":domain:basic"))

}
