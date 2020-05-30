package com.fantasyfang.developmenttool.extension

import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.net.wifi.WifiManager
import java.math.BigInteger
import java.net.InetAddress


fun Context.getIPV4Address(): String {
    val wifiManager = this.getSystemService(WIFI_SERVICE) as WifiManager
    val wifiInfo = wifiManager.connectionInfo
    val myIPAddress: ByteArray =
        BigInteger.valueOf(wifiInfo.ipAddress.toLong()).toByteArray().reversedArray()

    return InetAddress.getByAddress(myIPAddress).hostAddress
}