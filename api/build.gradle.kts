plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    id(Plugins.kapt)
}

dependencies {
    implementation(KotlinCore.kotlin)
    implementation(ThirdPartyLibraries.retrofit)
    implementation(ThirdPartyLibraries.koin)
    implementation(ThirdPartyLibraries.gson)
}


android {
    compileSdkVersion(Versions.compileSdkVersion)
    defaultConfig {
        minSdkVersion(Versions.minSdkVersion)
        targetSdkVersion(Versions.targetSdkVersion)
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



