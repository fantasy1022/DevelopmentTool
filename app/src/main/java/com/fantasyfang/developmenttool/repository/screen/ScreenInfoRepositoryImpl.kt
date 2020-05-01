package com.fantasyfang.developmenttool.repository.screen

import android.content.Context
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.data.ScreenItem
import com.fantasyfang.developmenttool.data.ScreenUIInfo


//TODO Add local data store
class ScreenInfoRepositoryImpl(private val context: Context) : ScreenInfoRepository {
    override fun getScreenInfo(): ScreenUIInfo {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay

        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        return ScreenUIInfo(
            listOf(
                ScreenInfo(Item(ScreenItem.REFRESH_RATE, display.refreshRate.toString())),
                ScreenInfo(Item(ScreenItem.DIMENSIONS, "${display.width} * ${display.height}")),
                ScreenInfo(Item(ScreenItem.PIXEL, "${metrics.widthPixels} * ${metrics.heightPixels}"))
            )
        )
    }
}

