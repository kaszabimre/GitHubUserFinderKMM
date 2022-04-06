plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Versions.targetsdk
    defaultConfig {
        applicationId = "io.imrekaszab.githubuserfinder.android"
        minSdk = Versions.minsdk
        targetSdk = Versions.targetsdk
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompiler
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))

    // AndroidX
    implementation(AndroidX.appCompat)

    // Compose
    implementation(Compose.compiler)
    implementation(Compose.ui)
    implementation(Compose.runtime)
    implementation(Compose.activity)
    implementation(Compose.material)


}