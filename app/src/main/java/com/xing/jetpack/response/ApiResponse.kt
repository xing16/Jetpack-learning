package com.xing.jetpack.response

data class ApiResponse<T>(val errorCode: Int, val errorMsg: String?, val data: T)