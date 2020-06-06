package com.fantasyfang.developmenttool.extension

import android.graphics.Point
import android.view.Display
import android.view.Surface.*
import com.fantasyfang.developmenttool.data.ScreenOrientationItem

fun Display.getOrientationString(): String {
    return when (rotation) {
        ROTATION_0, ROTATION_180 -> ScreenOrientationItem.ORIENTATION_PORTRAIT.value
        ROTATION_90, ROTATION_270 -> ScreenOrientationItem.ORIENTATION_LANDSCAPE.value
        else -> throw IllegalArgumentException()
    }
}

fun Display.getOrientationDegree(): String {
    return when (rotation) {
        ROTATION_0 -> "0°"
        ROTATION_90 -> "90°"
        ROTATION_180 -> "180°"
        ROTATION_270 -> "270°"
        else -> throw IllegalArgumentException()
    }
}

fun Display.getRealWidth(): Int {
    return Point().also {
        this.getSize(it)
    }.x
}

fun Display.getRealHeight(): Int {
    return Point().also {
        this.getSize(it)
    }.y
}
