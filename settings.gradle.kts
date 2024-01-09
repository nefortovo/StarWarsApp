pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NewsApp"
include(":app",
    ":backend:utils",
    ":backend:starWars",

    ":domain:impl",
    ":domain:basic",

    ":data:impl",
    ":data:basic",

    ":common:domain")
