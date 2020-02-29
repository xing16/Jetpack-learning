package com.xing.jetpack.api

import com.xing.jetpack.response.ApiResponse
import com.xing.jetpack.model.Banner
import retrofit2.http.GET

interface ApiService {

    @GET("banner/json")
    suspend fun loadBanner(): ApiResponse<List<Banner>>

}