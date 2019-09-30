/**
 * Created by Umur Kaya on 28-Sep-19.
 */
object KotlinCore{
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
}
object AndroidCoreLibraries{
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
}

object ThirdPartyLibraries {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val koin = "org.koin:koin-android:${Versions.koinVersion}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koinVersion}"
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.sspVersion}"
    const val sdp = "com.intuit.sdp:sdp-android:${Versions.sdpVersion}"
}

object TestLibraries {
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val runnner = "com.android.support.test:runner:${Versions.testRunnerVersion}"
    const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val archCoreTesting = "android.arch.core:core-testing:1.0.0"
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val coroutinesTesting = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
}