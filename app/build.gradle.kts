plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("kotlin-android")
    id("kotlin-parcelize") // Add this line
}

android {
    namespace = "com.example.newsgenz"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newsgenz"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)  // For JSON conversion

    // Coroutines for asynchronous programming
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // RecyclerView for displaying lists
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)


    // Glide for image loading
    implementation(libs.glide)
    kapt("com.github.bumptech.glide:compiler:4.12.0") // For annotation processing

    // OkHttp Logging Interceptor for logging network requests
    implementation(libs.logging.interceptor)

    // Navigation Component for handling app navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Room for local database
    implementation(libs.androidx.room.runtime)
    kapt("androidx.room:room-compiler:2.4.2")  // For annotation processing
    implementation(libs.androidx.room.ktx) // KTX extensions for coroutines support
    implementation(libs.material.v190)

    implementation(libs.gson)

    // CardView for displaying cards
    implementation(libs.androidx.cardview)

}