package com.xing.jetpack.base

import androidx.lifecycle.ViewModel
import com.xing.jetpack.ApiRepository

open class BaseViewModel : ViewModel() {

    val apiRepository: ApiRepository = ApiRepository()


}