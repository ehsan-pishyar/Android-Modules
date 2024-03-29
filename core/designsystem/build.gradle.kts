plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.designsystem"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_18.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    val androidCoreVersion = "1.10.1"
    val paletteVersion = "1.0.0"
    val accompanistVersion = "0.27.0"

    implementation("androidx.core:core-ktx:$androidCoreVersion")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.ui:ui-graphics")
    implementation(platform("androidx.compose:compose-bom:2022.10.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Palette
    implementation("androidx.palette:palette-ktx:$paletteVersion")

    // Coil
    implementation("io.coil-kt:coil-compose:2.3.0")

    // Pager and Indicators - Accompanist - System ui controller - Swipe to refresh
    implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.3-beta")
    implementation("com.google.accompanist:accompanist-swiperefresh:0.30.1")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.30.0")
    implementation("com.google.accompanist:accompanist-flowlayout:0.27.0")
    implementation("com.google.accompanist:accompanist-insets-ui:0.23.1")
}