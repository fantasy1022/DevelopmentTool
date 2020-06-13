package com.fantasyfang.developmenttool.extension

import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.net.wifi.WifiManager
import com.fantasyfang.developmenttool.repository.Result
import java.math.BigInteger
import java.net.InetAddress


fun Context.getIPV4Address(): Result {
    //TODO: Add try catch
    val wifiManager = this.getSystemService(WIFI_SERVICE) as WifiManager
    val wifiInfo = wifiManager.connectionInfo
    val myIPAddress: ByteArray =
        BigInteger.valueOf(wifiInfo.ipAddress.toLong()).toByteArray().reversedArray()

    return Result.Success(InetAddress.getByAddress(myIPAddress).hostAddress)
}