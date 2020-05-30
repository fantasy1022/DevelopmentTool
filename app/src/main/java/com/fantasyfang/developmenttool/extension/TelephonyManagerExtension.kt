package com.fantasyfang.developmenttool.extension

import android.Manifest
import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import androidx.annotation.RequiresPermission

@RequiresPermission(Manifest.permission.READ_PHONE_STATE)
fun Context.getDeviceIMEI(): String {
    val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            telephonyManager.imei
        } else {
            @Suppress("DEPRECATION")
            telephonyManager.deviceId
        }
    } catch (e: SecurityException) {
        "" //TODO: Add error enum
    }
}
