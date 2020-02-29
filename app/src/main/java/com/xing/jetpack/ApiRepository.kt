package com.xing.jetpack

import com.xing.jetpack.api.ApiService
import com.xing.jetpack.http.RetrofitClient
import com.xing.jetpack.model.Banner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiRepository {

    suspend fun loadBanner(): List<Banner> {
        return withContext(Dispatchers.IO) {
            val apiService = RetrofitClient.get().retrofit.create(ApiService::class.java)
            apiService.loadBanner().data
        }
    }


}