plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
}

android {
    namespace = "com.eduardovpessoa"
    defaultConfig {
        applicationId = "com.eduardovpessoa"
        compileSdk = 33
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
    }
    compileSdk = 33
    buildToolsVersion = "33.0.1"
}

dependencies {
    val composeActivityVersion = "1.6.1"
    val composeVersion = "1.4.0-alpha03"
    val coreKtxVersion = "1.9.0"
    val composeCharts = "0.1.2"
    val gMapsVersion = "18.1.0"
    val koinAndroidVersion = "3.3.1"
    val koinAndroidComposeVersion = "3.4.0"
    val kotlinxSerializationJsonVersion = "1.4.1"
    val kotlinxRetrofitSerializationConverterVersion = "0.8.0"
    val lifecycleRuntimeVersion = "2.5.1"
    val material3Version = "1.1.0-alpha03"
    val navVersion = "2.5.3"
    val okHttpVersion = "4.10.0"
    val retrofitVersion = "2.9.0"

    val androidTestEspressoVersion = "3.5.0"
    val androidTestExtJUnitVersion = "1.1.4"
    val testJUnitVersion = "4.13.2"

    // AndroidX + UI Libs
    implementation("androidx.activity:activity-compose:$composeActivityVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.compose.material3:material3:$material3Version")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeVersion")
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Compose Charts
    implementation("io.github.bytebeats:compose-charts:$composeCharts")

    // Debug
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // Dependency Injection (Koin)
    implementation("io.insert-koin:koin-android:$koinAndroidVersion")
    implementation("io.insert-koin:koin-androidx-compose:$koinAndroidComposeVersion")

    // Google Maps
    implementation("com.google.android.gms:play-services-maps:$gMapsVersion")

    // KotlinX Serialization
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$kotlinxRetrofitSerializationConverterVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationJsonVersion")

    // Network (OkHttp + Retrofit)
    // define a BOM and its version
    implementation(platform("com.squareup.okhttp3:okhttp-bom:$okHttpVersion"))
    // define any required OkHttp artifacts without version
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")

    // Unit Tests
    testImplementation("junit:junit:$testJUnitVersion")

    // UI Tests
    androidTestImplementation("androidx.test.ext:junit:$androidTestExtJUnitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$androidTestEspressoVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
}