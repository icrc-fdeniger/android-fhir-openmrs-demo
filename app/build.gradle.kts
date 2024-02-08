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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
        freeCompilerArgs = listOf("-Xjvm-default=all-compatibility")
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
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    implementation("com.google.android.fhir:engine:0.1.0-beta05")
    implementation("org.slf4j:slf4j-simple:2.0.10")
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.0")
    implementation("androidx.work:work-runtime-ktx:2.8.1")

    androidTestImplementation("androidx.test:core:1.5.0")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")
    androidTestImplementation("androidx.room:room-testing:2.5.2")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("com.google.truth:truth:1.1.5")
    androidTestImplementation("androidx.work:work-testing:2.8.1")

    testImplementation("androidx.test:core:1.5.0")
    testImplementation("androidx.test.ext:junit-ktx:1.1.5")
    testImplementation("androidx.room:room-testing:2.5.2")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.1.5")
    testImplementation("androidx.work:work-testing:2.8.1")
    testImplementation("org.robolectric:robolectric:4.10.3")
}