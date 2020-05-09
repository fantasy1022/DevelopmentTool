package com.fantasyfang.developmenttool.extension

import android.util.DisplayMetrics
import kotlin.math.pow
import kotlin.math.sqrt

fun DisplayMetrics.getHeightDP() = heightPixels / density
fun DisplayMetrics.getWidthDP() = widthPixels / density

fun DisplayMetrics.getScreenInch(): Double {
    val x = (widthPixels.toDouble() / xdpi).pow(2.0)
    val y = (heightPixels.toDouble() / ydpi).pow(2.0)
    return sqrt(x + y)
}