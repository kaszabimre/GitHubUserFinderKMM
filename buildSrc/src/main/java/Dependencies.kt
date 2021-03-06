
object Versions {
    const val minsdk = 23
    const val targetsdk = 32
    const val gradle = "7.1.3"
    const val kotlin = "1.7.0"
    const val coroutines = "1.6.3"
    const val appCompat = "1.4.1"

    const val compose = "1.2.0-rc03"
    const val composeActivity = "1.5.0"
    const val composeCompiler = "1.2.0"
    const val composeCoil = "2.1.0"
    const val composeNavigation = "2.4.2"

    const val koin = "3.2.0"
    const val ktor = "2.0.3"
    const val kermit = "1.1.3"
    const val ktlint = "10.3.0"
}

object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
}

object Kotlin {
    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}-native-mt"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }
}

object Compose {
    const val compiler = "androidx.compose.compiler:compiler:${Versions.composeCompiler}"
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val coilCompose = "io.coil-kt:coil-compose:${Versions.composeCoil}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
    const val preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
}

object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koin}"
    const val android = "io.insert-koin:koin-android:${Versions.koin}"
    const val compose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
}

object Ktor {
    const val ktorCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    const val ktorSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
    const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
    const val ktorAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    const val ktoriOS = "io.ktor:ktor-client-ios:${Versions.ktor}"
    const val logging = "io.ktor:ktor-client-logging:${Versions.ktor}"
}

object Kermit {
    const val logging = "co.touchlab:kermit:${Versions.kermit}"
}

object Test {
    const val ktor = "io.ktor:ktor-client-mock:${Versions.ktor}"
    const val koin = "io.insert-koin:koin-test:${Versions.koin}"
}
