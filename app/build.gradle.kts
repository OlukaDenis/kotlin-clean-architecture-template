import com.google.protobuf.gradle.protoc
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.protobuf") version Versions.ProtoBuf.PLUGIN
}

android {
    compileSdk = Dependencies.ProjectConstants.COMPILE_SDK
    buildToolsVersion = Dependencies.ProjectConstants.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = Dependencies.ProjectConstants.MINIMUM_SDK
        targetSdk = Dependencies.ProjectConstants.TARGET_SDK
        applicationId = Dependencies.ProjectConstants.BASE
        versionCode = Dependencies.ProjectConstants.VERSION_CODE
        versionName = Dependencies.ProjectConstants.VERSION_NAME
        multiDexEnabled = true
        testInstrumentationRunner = Dependencies.ProjectConstants.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        named("debug") {
            buildConfigField("String", "BASE_URL", "\"https://admin.pieme.info/WebService/\"")
        }

        named("release") {
            buildConfigField("String", "BASE_URL", "\"https://admin.pieme.info/WebService/\"")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
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
        viewBinding = true
    }
}

dependencies {

    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.MATERIAL)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.FRAGMENT_KTX)
    implementation(Dependencies.AndroidX.ACTIVITY_KTX)
    implementation(Dependencies.AndroidX.LIVEDATA_KTX)
    implementation(Dependencies.AndroidX.VIEWMODEL_KTX)
    implementation(Dependencies.AndroidX.DATA_STORE)

    implementation(Dependencies.ProtoBuf.CORE)

    implementation(Dependencies.Util.TIMBER)
    implementation(Dependencies.Util.COIL)
    implementation(Dependencies.Util.JAVA_JWT)
    implementation(Dependencies.Util.SHIMMER)
    implementation(Dependencies.Util.CIRCLE_IMAGE_VIEW)

    implementation(Dependencies.AndroidX.PLAY_CORE)
    implementation(Dependencies.Kotlin.COROUTINE_ANDROID)
    implementation(Dependencies.AndroidX.PAGING)

    implementation(Dependencies.Network.OKHTTP)
    implementation(Dependencies.Network.RETROFIT)
    implementation(Dependencies.Network.GSON_CONVERTER)
    implementation(Dependencies.Network.LOGGING_INTERCEPTOR)

    implementation(Dependencies.Hilt.ANDROID)
    kapt(Dependencies.Hilt.COMPILER)

    implementation(Dependencies.AndroidX.PAGING)

    testImplementation(Dependencies.Kotlin.COROUTINE_TEST)

    implementation(Dependencies.Hilt.HILT_WORKER)
    implementation(Dependencies.Hilt.ANDROID)
    kapt(Dependencies.Hilt.COMPILER)

    kapt(Dependencies.AndroidX.LIFECYCLE_PROCESSOR)

    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.JUNIT_EXT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
}

protobuf {
    protobuf.protoc { artifact = Dependencies.ProtoBuf.ARTIFACT }
    protobuf.generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                id("java") {
                    option("lite")
                }
            }
        }
    }
}