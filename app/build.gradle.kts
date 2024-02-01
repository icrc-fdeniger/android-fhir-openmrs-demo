plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "org.icrc.fhir.demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.icrc.fhir.demo"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.1"
//    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
// fhir start
    implementation("com.google.android.fhir:common:0.1.0-alpha05")
    implementation("org.slf4j:slf4j-simple:2.0.10")
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("org.fhir:ucum:1.0.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.github.java-json-tools:json-patch:1.13")

    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("net.zetetic:android-database-sqlcipher:4.5.4")

//  to be removed
    implementation("com.jakewharton.timber:timber:5.0.1")
//
// fhir end
//    implementation("androidx.core:core-ktx:1.12.0")
//    implementation("androidx.work:work-runtime-ktx:2.8.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
//    implementation("androidx.activity:activity-compose:1.8.2")
//    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    implementation("androidx.compose.material3:material3")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation("junit:junit:4.13.2")
//    testImplementation("androidx.test:core:1.5.0")
//    testImplementation("org.mockito:mockito-core:5.10.0")
//    testImplementation("org.robolectric:robolectric:4.11.1")
}