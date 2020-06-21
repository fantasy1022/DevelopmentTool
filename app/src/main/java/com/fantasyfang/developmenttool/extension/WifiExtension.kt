package com.fantasyfang.developmenttool.extension

import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.net.wifi.WifiManager
import com.fantasyfang.developmenttool.repository.Result
import java.math.BigInteger
import java.net.InetAddress
import java.net.UnknownHostException

fun Context.getIPV4Address(): Result {
    return try {
        val wifiManager = this.getSystemService(WIFI_SERVICE) as WifiManager
        val wifiInfo = wifiManager.connectionInfo
        val myIPAddress: ByteArray =
            BigInteger.valueOf(wifiInfo.ipAddress.toLong()).toByteArray().reversedArray()
        Result.Success(InetAddress.getByAddress(myIPAddress).hostAddress)
    } catch (e: UnknownHostException) {
        e.printStackTrace()
        Result.FailureLackWifi(e)
    }
}