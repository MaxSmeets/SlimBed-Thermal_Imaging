plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.samples.flironecamera"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.samples.flironecamera"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    repositories {
        flatDir {
            dirs("libs")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

repositories {
    flatDir {
        dirs("../../../modules/thermalsdk/build/outputs/aar")
        dirs("../../../modules/androidsdk/build/outputs/aar")
        dirs("../../../MastodonAndroid/prebuilt-aar")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.jetbrains.annotations)

    // Add Atlas Android SDK 'aar' libraries
    implementation("com.samples:thermalsdk-release@aar")
    implementation("com.samples:androidsdk-release@aar")
}
