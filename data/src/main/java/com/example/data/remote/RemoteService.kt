package com.example.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteService {
    private const val BASE_URL = "https://earthquake.usgs.gov/"

    val retrofitClient: Retrofit.Builder by lazy {
        val levelType = Level.HEADERS
        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val remoteApiInterface: RemoteApiInterface by lazy {
        retrofitClient
            .build()
            .create(RemoteApiInterface::class.java)
    }
}

