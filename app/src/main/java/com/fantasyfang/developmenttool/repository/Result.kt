package com.fantasyfang.developmenttool.repository

import android.Manifest

sealed class Result {
    data class Success(val string: String) : Result()
    data class FailureLackPermission(val lackPermission: LackPermission) : Result()
    data class FailureLackWifi(val exception: Exception) : Result()
}

enum class LackPermission(val value: String) {
    READ_PHONE_STATE_PERMISSION(Manifest.permission.READ_PHONE_STATE)
}

//enum class InternetException(val exception: String){
//    UNKNOWN_HOST_EXCEPTION(UnknownHostException::class.simpleName)
//}