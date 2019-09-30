plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kapt)
}

android {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        applicationId = "net.xanir.starwars"
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
        versionCode = Release.version
        versionName = Release.versionName
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    dataBinding{
        isEnabled = true
    }
}

dependencies {
    implementation(KotlinCore.kotlin)
    implementation(project(Modules.api))
    implementation(project(Modules.characterList))
    implementation(project(Modules.characterDetail))
    implementation(project(Modules.androidCommons))

    implementation(AndroidCoreLibraries.appCompat)
    implementation(AndroidCoreLibraries.viewModel)
    implementation(AndroidCoreLibraries.liveDataKtx)
    implementation(AndroidCoreLibraries.runtimeKtx)
    implementation(AndroidCoreLibraries.legacySupport)
    implementation(AndroidCoreLibraries.material)
    implementation(AndroidCoreLibraries.constraintLayout)
    implementation(AndroidCoreLibraries.lifecycleExtensions)

    implementation(AndroidCoreLibraries.navigationFragment)
    implementation(AndroidCoreLibraries.navigationUI)

    implementation(ThirdPartyLibraries.koin)
    implementation(ThirdPartyLibraries.koinViewModel)

    implementation(ThirdPartyLibraries.ssp)
    implementation(ThirdPartyLibraries.sdp)

    implementation(ThirdPartyLibraries.retrofit)
    implementation(ThirdPartyLibraries.gson)

    // Testing
    androidTestImplementation(TestLibraries.runnner)
    androidTestImplementation(TestLibraries.espressoCore)
}
