package com.fantasyfang.developmenttool.extension

import android.util.DisplayMetrics
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun DisplayMetrics.getHeightDP() = (heightPixels / density).roundToInt()
fun DisplayMetrics.getWidthDP() = (widthPixels / density).roundToInt()

fun DisplayMetrics.getScreenInch(): Float {
    val x = (widthPixels.toDouble() / xdpi).pow(2.0)
    val y = (heightPixels.toDouble() / ydpi).pow(2.0)
    return ((sqrt(x + y) * 10).roundToInt()) / 10f
}