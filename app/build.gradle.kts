plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = StarWarsClient.DefaultConfig.id
    compileSdk = StarWarsClient.DefaultConfig.compileSdk

    defaultConfig {

        applicationId = StarWarsClient.DefaultConfig.id
        minSdk = StarWarsClient.DefaultConfig.minSdk
        targetSdk = StarWarsClient.DefaultConfig.targetSdk
        versionCode = StarWarsClient.DefaultConfig.versionCode
        versionName = StarWarsClient.DefaultConfig.versionName

        with(StarWarsClient.DefaultConfig.starWarsBackend) {
            buildConfigField(
                type = type,
                name = name,
                value = value
            )
        }


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = StarWarsClient.DefaultConfig.jVersion
        targetCompatibility = StarWarsClient.DefaultConfig.jVersion
    }
    kotlinOptions {
        jvmTarget = StarWarsClient.DefaultConfig.jvmTarget
        freeCompilerArgs += listOf("-opt-in=androidx.compose.material3.ExperimentalMaterial3Api")
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion =
            StarWarsClient.DefaultConfig.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.Core.Ktx.lib)

    implementation(Dependencies.Core.Lifecycle.libRuntime)
    implementation(Dependencies.Core.Lifecycle.libCommon)
    implementation(Dependencies.Core.Lifecycle.libViewModels)
    implementation(Dependencies.Core.Lifecycle.libCompose)

    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiToolingPreview)
    debugImplementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.navLib)

    implementation(Dependencies.Splashscreen.lib)

    implementation(Dependencies.Matherial.material)
    implementation(Dependencies.Matherial.material3)

    implementation(Dependencies.Coil.lib)
    implementation(Dependencies.Coil.libSvg)

    testImplementation(Dependencies.Testing.JUnit.junit)
    androidTestImplementation(Dependencies.Testing.JUnit.junitExt)

    androidTestImplementation(Dependencies.Testing.Espresso.lib)

    implementation(Dependencies.DaggerHilt.hilt)
    kapt(Dependencies.DaggerHilt.daggerHiltCompiler)
    implementation(Dependencies.DaggerHilt.hiltCompose)

    implementation(Dependencies.Coroutines.lib)

    implementation(Dependencies.Compose.matherialIcons)
    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingCompose)

    implementation(project(":backend:starWars"))
    implementation(project(":backend:utils"))

    implementation(project(":domain:impl"))
    implementation(project(":data:impl"))
    implementation(project(":common:domain"))

}

kapt {
    correctErrorTypes = true
}