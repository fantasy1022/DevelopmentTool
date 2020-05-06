package com.fantasyfang.developmenttool.extension

import android.util.DisplayMetrics

fun DisplayMetrics.getHeightDP() = heightPixels / density
fun DisplayMetrics.getWidthDP() = widthPixels / density