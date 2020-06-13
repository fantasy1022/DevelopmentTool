package com.fantasyfang.developmenttool.extension

import android.Manifest
import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import androidx.annotation.RequiresPermission
import com.fantasyfang.developmenttool.repository.LackPermission
import com.fantasyfang.developmenttool.repository.Result

@RequiresPermission(Manifest.permission.READ_PHONE_STATE)
fun Context.getDeviceIMEI(): Result {
    val telephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Result.Success(telephonyManager.imei)
        } else {
            @Suppress("DEPRECATION")
            Result.Success(telephonyManager.deviceId)
        }
    } catch (e: SecurityException) {
        Result.FailureLackPermission(LackPermission.READ_PHONE_STATE_PERMISSION)
    }
}
