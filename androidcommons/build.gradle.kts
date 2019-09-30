plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kapt)
}

dependencies {
    implementation(KotlinCore.kotlin)

    implementation(AndroidCoreLibraries.appCompat)
    implementation(AndroidCoreLibraries.viewModel)
    implementation(AndroidCoreLibraries.liveDataKtx)
    implementation(AndroidCoreLibraries.runtimeKtx)
    implementation(AndroidCoreLibraries.legacySupport)
    implementation(AndroidCoreLibraries.material)
    implementation(AndroidCoreLibraries.constraintLayout)
    implementation(AndroidCoreLibraries.lifecycleExtensions)

    implementation(ThirdPartyLibraries.koin)
    implementation(ThirdPartyLibraries.koinViewModel)

    implementation(AndroidCoreLibraries.navigationUI)
    implementation(AndroidCoreLibraries.navigationFragment)

}


android {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
    }
    dataBinding{
        isEnabled = true
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(ClassPaths.kotlinPath)
    }
}

repositories{
    mavenCentral()
}