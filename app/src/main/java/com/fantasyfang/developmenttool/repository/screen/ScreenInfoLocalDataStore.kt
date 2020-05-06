package com.fantasyfang.developmenttool.repository.screen

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.data.ScreenItem
import com.fantasyfang.developmenttool.data.ScreenUIInfo
import com.fantasyfang.developmenttool.extension.getHeightDP
import com.fantasyfang.developmenttool.extension.getOrientationString
import com.fantasyfang.developmenttool.extension.getWidthDP
import com.fantasyfang.developmenttool.repository.LocalDataStore
import kotlin.math.min
import kotlin.math.roundToInt

class ScreenInfoLocalDataStore(private val context: Context) : LocalDataStore<ScreenUIInfo> {

    override fun getData(): ScreenUIInfo {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay

        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        //TODO: how to get info
        return ScreenUIInfo(
            listOf(
                ScreenInfo(
                    Item(
                        ScreenItem.REFRESH_RATE,
                        display.refreshRate.roundToInt().toString()
                    )
                ),
                ScreenInfo(
                    Item(
                        ScreenItem.WIDTH_PX,
                        metrics.widthPixels.toString()
                    )
                ),//TODO: need fix
                ScreenInfo(
                    Item(
                        ScreenItem.HEIGHT_PX,
                        metrics.heightPixels.toString()
                    )
                ),//TODO: need fix
                ScreenInfo(Item(ScreenItem.DENSITY, metrics.density.toString())),
                ScreenInfo(Item(ScreenItem.DENSITY_DPI, metrics.densityDpi.toString())),
                ScreenInfo(Item(ScreenItem.DRAWABLE_DENSITY, "xxHdpi")),//TODO: get right dpi
                ScreenInfo(Item(ScreenItem.LAYOUT_SIZE, "normal")),//TODO: get layout size
                ScreenInfo(
                    Item(
                        ScreenItem.WIDTH_DP, metrics.getWidthDP().toString()
                    )
                ),
                ScreenInfo(
                    Item(ScreenItem.HEIGHT_DP, metrics.getHeightDP().toString())
                ),
                ScreenInfo(Item(ScreenItem.USABLE_WIDTH_PX, metrics.widthPixels.toString())),
                ScreenInfo(Item(ScreenItem.USABLE_HEIGHT_PX, metrics.heightPixels.toString())),
                ScreenInfo(
                    Item(
                        ScreenItem.SMALL_DP,
                        min(metrics.getHeightDP(), metrics.getWidthDP()).toString()
                    )
                ),
                ScreenInfo(Item(ScreenItem.ORIENTATION, display.getOrientationString().name))
            )
        )
    }

    private fun getHeightDP(metrics: DisplayMetrics) = (metrics.heightPixels / metrics.density)

}