object Dependencies {

    object Gradle {
        private const val version = "8.2.0"
        const val plugin = "com.android.tools.build:gradle:$version"
    }

    object Kotlin {
        private const val version = "1.8.10"
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Compose {
        private const val version = "1.4.3"
        private const val versionActivity = "1.7.2"
        private const val versionNav = "2.5.1"
        const val matherialIcons = "androidx.compose.material:material-icons-extended:$version"
        const val navLib = "androidx.navigation:navigation-compose:$versionNav"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val activity = "androidx.activity:activity-compose:$versionActivity"
    }

    object Matherial{
        private const val matherialVersion = "1.4.3"
        private const val matherial3Version = "1.1.1"
        const val material = "androidx.compose.material:material:$matherialVersion"
        const val material3 = "androidx.compose.material3:material3:$matherial3Version"
    }

    object Room{
        private const val room_version = "2.6.1"
        const val roomRuntime = "androidx.room:room-runtime:$room_version"
        const val annotationProcessor = "androidx.room:room-compiler:$room_version"
        const val roomKapt = "androidx.room:room-compiler:$room_version"
        const val roomKtx = "androidx.room:room-ktx:$room_version"
    }

    object Core {
        object Ktx {
            private const val version = "1.8.0"
            const val lib = "androidx.core:core-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.6.2"
            const val libRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val libCommon = "androidx.lifecycle:lifecycle-common:$version"
            const val libViewModels = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val libCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

    }


    object Coroutines{
        private const val version = "1.6.4"
        const val lib = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Network {
        object Retrofit {
            private const val version = "2.9.0"
            const val lib = "com.squareup.retrofit2:retrofit:$version"
        }

        object Gson {
            private const val version = "2.9.0"
            const val lib = "com.squareup.retrofit2:converter-gson:$version"
        }

        object Logging {
            private const val version = "4.10.0"
            const val lib = "com.squareup.okhttp3:logging-interceptor:$version"
        }

        object OkHttp{
            private const val version = "4.10.0"
            const val lib = "com.squareup.okhttp3:okhttp:$version"
        }
    }

    object DaggerHilt {
        private const val version = "2.48"
        private const val hiltComposeVersion = "1.0.0"
        const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:$version"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:$hiltComposeVersion"
        const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Paging{
        private const val version_paging = "3.1.1"
        const val pagingLib = "androidx.paging:paging-runtime:$version_paging"

        private const val paging_compose_version = "1.0.0-alpha17"
        const val pagingCompose =  "androidx.paging:paging-compose:$paging_compose_version"
    }


    object Coil{
        private const val version = "2.4.0"
        const val lib = "io.coil-kt:coil-compose:$version"
        const val libSvg = "io.coil-kt:coil-svg:$version"
    }
    

    object Splashscreen{
        private const val version = "1.0.0"
        const val lib = "androidx.core:core-splashscreen:$version"
    }



    object Json{
        private const val jsonVersion = "1.6.1"
        const val lib = "org.jetbrains.kotlinx:kotlinx-serialization-json:$jsonVersion"

        const val classpathJsonDeps = "plugin.serialization"

        private const val serializationConverterVersion = "1.0.0"
        const val serializationConverterLib = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$serializationConverterVersion"
    }

    object Testing{

        //UNIT TESTING
        object JUnit{
            private const val versionJunit = "4.13.2"
            const val junit = "junit:junit:$versionJunit"

            private const val versionExt = "1.1.5"
            const val junitExt = "androidx.test.ext:junit:$versionExt"
        }

        //UI TESTING
        object Espresso{
            private const val version = "3.5.1"
            const val lib = "androidx.test.espresso:espresso-core:$version"
        }
    }

}