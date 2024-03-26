package com.example.ranch24.network.utils

import com.example.ranch24.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RanchClient {
    private fun okHttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(75, TimeUnit.SECONDS)
            .writeTimeout(75, TimeUnit.SECONDS)
            .readTimeout(75, TimeUnit.SECONDS)

        okHttpClient.addInterceptor(interceptor)

        return okHttpClient.build()
    }

    val baseUrl: Retrofit
        get() = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL + "/")
            .client(okHttpClient())
            .build()
}