plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}
android {
    namespace = StarWarsClient.namespace("domain.impl")
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
    implementation(Dependencies.Coroutines.lib)

    implementation(Dependencies.DaggerHilt.hilt)
    kapt(Dependencies.DaggerHilt.daggerHiltCompiler)
    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingCompose)

    api(project(":domain:basic"))
    implementation(project(":data:basic"))
    implementation(project(":common:domain"))

}
