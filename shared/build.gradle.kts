plugins {
    kotlin("multiplatform")
    id("org.jetbrains.kotlin.plugin.serialization") version Versions.kotlin
    id("com.android.library")
    id("org.jlleitschuh.gradle.ktlint")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Kotlin.Coroutines.core)
                implementation(Koin.core)
                implementation(Ktor.ktorCore)
                implementation(Ktor.ktorSerialization)
                implementation(Ktor.ktorContentNegotiation)
                implementation(Ktor.logging)
                implementation(Kermit.logging)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation(Test.ktor)
                implementation(Test.koin)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Ktor.ktorAndroid)
                implementation(Kotlin.Coroutines.android)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                implementation(Ktor.ktoriOS)
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            // TODO: uncomment this dependency if there is a KMM mocking/di framework for tests
            // dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = Versions.targetsdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.minsdk
        targetSdk = Versions.targetsdk
    }
}
