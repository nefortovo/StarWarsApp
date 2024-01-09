plugins{
    `kotlin-dsl`
}

repositories{
    mavenCentral()
    mavenLocal()
    google()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}

kotlin{
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}