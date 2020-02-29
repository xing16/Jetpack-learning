package com.xing.jetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xing.jetpack.api.ApiService
import com.xing.jetpack.base.BaseViewModel
import com.xing.jetpack.http.RetrofitClient
import com.xing.jetpack.model.Banner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BannerViewModel : BaseViewModel() {

    val liveData: MutableLiveData<List<Banner>> by lazy {
        MutableLiveData<List<Banner>>().also {
            loadBanner()
        }
    }

    private fun loadBanner() {
        viewModelScope.launch(Dispatchers.Main) {
            val result = apiRepository.loadBanner()
            liveData.value = result
        }
    }


}