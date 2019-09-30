plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kapt)
}

dependencies {
    implementation(KotlinCore.kotlin)

    api(project(Modules.api))
    implementation(project(Modules.androidCommons))

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

    implementation(ThirdPartyLibraries.ssp)
    implementation(ThirdPartyLibraries.sdp)

    implementation(AndroidCoreLibraries.navigationUI)
    implementation(AndroidCoreLibraries.navigationFragment)

    testImplementation(TestLibraries.jUnit)
    testImplementation(TestLibraries.archCoreTesting)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.coroutinesTesting)
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
    testOptions {
        unitTests.isReturnDefaultValues = true
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



