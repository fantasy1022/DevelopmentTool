package com.fantasyfang.developmenttool.extension

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import com.fantasyfang.developmenttool.repository.Result

@SuppressLint("HardwareIds")
fun Context.getAndroidId(): Result =
    Result.Success(Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID))
