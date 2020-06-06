package com.fantasyfang.developmenttool.extension

import android.content.Context
import android.content.res.Configuration
import android.content.res.TypedArray
import android.util.DisplayMetrics
import android.view.Display
import com.fantasyfang.developmenttool.R
import com.fantasyfang.developmenttool.data.ScreenOrientationItem


fun Context.getLayoutSize(
    display: Display,
    displayMetrics: DisplayMetrics
): String =
    if (isTablet(this)) {
        getSizeByOrientation(display,
            { getTabletSize(displayMetrics, 720) },
            { getTabletSize(displayMetrics, 1024) })
    } else {
        getSizeByOrientation(display,
            { getPhoneSize(displayMetrics, 360, 400) },
            { getPhoneSize(displayMetrics, 600, 720) })
    }

private fun getSizeByOrientation(
    display: Display,
    size1: () -> String,
    size2: () -> String
): String {
    return if (display.getOrientationString() == ScreenOrientationItem.ORIENTATION_PORTRAIT.value) {
        size1()
    } else {
        size2()
    }
}

private fun getTabletSize(displayMetrics: DisplayMetrics, boundary: Int): String {
    return if (displayMetrics.getWidthDP() < boundary) {
        "small"
    } else {
        "large"
    }
}

private fun getPhoneSize(displayMetrics: DisplayMetrics, boundary: Int, boundary2: Int): String {
    return when {
        displayMetrics.getWidthDP() < boundary -> {
            "small"
        }
        displayMetrics.getWidthDP() < boundary2 -> {
            "medium"
        }
        else -> {
            "large"
        }
    }
}

fun Context.getStatusBarHeight(): Int {
    val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else {
        0
    }
}

fun Context.getNavigationBarHeight(): Int {
    val resourceId: Int = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else {
        0
    }
}

fun Context.getActionBarHeight(): Int {
    val styledAttributes: TypedArray = theme
        .obtainStyledAttributes(intArrayOf(R.attr.actionBarSize))
    return styledAttributes.getDimension(0, 0f).toInt().apply {
        styledAttributes.recycle()
    }
}

private fun isTablet(context: Context): Boolean {
    return ((context.resources.configuration.screenLayout
            and Configuration.SCREENLAYOUT_SIZE_MASK)
            >= Configuration.SCREENLAYOUT_SIZE_LARGE)
}