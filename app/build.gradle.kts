plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")//Room
    id ("dagger.hilt.android.plugin")   //dagger_hilt
    id ("com.google.dagger.hilt.android")

}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        viewBinding.enable=true
        dataBinding.enable=true
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
    implementation(libs.androidx.navigation.fragment)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Coroutines
    implementation(libs.kotlinx.coroutines.core)

    // Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //viewmodel
    implementation(libs.androidx.lifecycle.viewmodel )// For Kotlin use lifecycle-viewmodel-ktx
   // alternatively - just LiveData
    implementation (libs.androidx.lifecycle.livedata)

    // Glide
    implementation (libs.glide)


    // Intuit
    implementation (libs.sdp.android)
    implementation (libs.ssp.android)

    //Room
    val room_version = "2.6.1"
    implementation (libs.androidx.room.runtime)
    kapt (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)


    //datastore
    implementation (libs.androidx.datastore.preferences)

    //viewpager
    implementation(libs.androidx.viewpager2)


    //Dagger Hilt
    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)
    kapt (libs.androidx.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)
    implementation (libs.androidx.activity.ktx)

    //Splash Api
    implementation (libs.androidx.core.splashscreen)



}