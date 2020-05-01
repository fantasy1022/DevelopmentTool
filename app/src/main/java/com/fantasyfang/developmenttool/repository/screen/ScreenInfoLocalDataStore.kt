package com.fantasyfang.developmenttool.repository.screen

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.data.ScreenItem
import com.fantasyfang.developmenttool.data.ScreenUIInfo
import com.fantasyfang.developmenttool.repository.LocalDataStore
import kotlin.math.roundToInt

class ScreenInfoLocalDataStore(private val context: Context) : LocalDataStore<ScreenUIInfo> {

    override fun getData(): ScreenUIInfo {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay

        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        return ScreenUIInfo(
            listOf(
                ScreenInfo(
                    Item(
                        ScreenItem.REFRESH_RATE,
                        display.refreshRate.roundToInt().toString()
                    )
                ),
                ScreenInfo(Item(ScreenItem.WIDTH, metrics.widthPixels.toString())),
                ScreenInfo(Item(ScreenItem.HEIGHT, metrics.heightPixels.toString()))
            )
        )
    }
}