package net.xanir.api.di

import net.xanir.api.BuildConfig
import net.xanir.api.api.ApiServices
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Umur Kaya on 28-Sep-19.
 */
const val BASE_URL = "https://swapi.co/api/"
val apiModule = module{
    single{
        val httpBuilder = OkHttpClient.Builder()
        httpBuilder.readTimeout(10, TimeUnit.SECONDS)
        httpBuilder.writeTimeout(30, TimeUnit.SECONDS)
        httpBuilder.addInterceptor { chain ->
            val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("Platform-Information", "Android")
            requestBuilder.addHeader("Application-Version", BuildConfig.VERSION_NAME)
            chain.proceed(requestBuilder.build())
        }
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiServices::class.java)
    }
}