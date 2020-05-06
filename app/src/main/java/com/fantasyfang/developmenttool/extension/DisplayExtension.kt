package com.fantasyfang.developmenttool.extension

import android.view.Display
import android.view.Surface.*
import com.fantasyfang.developmenttool.data.ScreenOrientationItem

fun Display.getOrientationString(): ScreenOrientationItem {
    return when (rotation) {
        ROTATION_0, ROTATION_180 -> ScreenOrientationItem.ORIENTATION_PORTRAIT
        ROTATION_90, ROTATION_270 -> ScreenOrientationItem.ORIENTATION_LANDSCAPE
        else -> throw IllegalArgumentException()
    }
}