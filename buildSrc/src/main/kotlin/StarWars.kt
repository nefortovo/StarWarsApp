import org.gradle.api.JavaVersion

object StarWarsClient {
    const val appName = "StarWars"
    const val dimension = "StarWars"

    object DefaultConfig {
        const val id = "com.example.starWars"
        const val minSdk = 26
        const val targetSdk = 33
        const val versionCode = 1
        const val releseNumber = 1
        const val compileSdk = 33
        const val versionName = "0.$releseNumber.$versionCode"
        const val kotlinCompilerExtensionVersion = "1.4.3"

        val starWarsBackend = Field(
            type = "String",
            name = "STARWARS_BACKEND",
            value = "\"https://swapi.dev/api/\"",
        )

        val jvmTarget = JavaVersion.VERSION_17.toString()
        val jVersion = JavaVersion.VERSION_17

    }
    fun namespace(currentPackage: String): String = "${DefaultConfig.id}.$currentPackage"
}

data class Field(
    val type : String,
    val name : String,
    val value : String,
)