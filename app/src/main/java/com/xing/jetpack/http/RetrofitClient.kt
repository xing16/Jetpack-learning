package com.xing.jetpack.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    val BASE_URL = "https://www.wanandroid.com/"

    private var okHttpClient: OkHttpClient
    var retrofit: Retrofit


    companion object {
        private var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }

        fun get(): RetrofitClient {
            return instance!!
        }
    }


    private constructor() {
        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(6 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(6 * 1000, TimeUnit.MILLISECONDS)
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}