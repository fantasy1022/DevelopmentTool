package com.fantasyfang.developmenttool.repository.screen

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.fantasyfang.developmenttool.data.Item
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.data.ScreenItem
import com.fantasyfang.developmenttool.extension.*
import com.fantasyfang.developmenttool.repository.LocalDataStore
import javax.inject.Inject
import kotlin.math.min
import kotlin.math.roundToInt

class ScreenInfoLocalDataStore @Inject constructor(private val context: Context) :
    LocalDataStore<List<ScreenInfo>> {

    override fun getData(): List<ScreenInfo> {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay

        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        return listOf(
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
                ScreenInfo(Item(ScreenItem.ORIENTATION, display.getOrientationString())),
                ScreenInfo(Item(ScreenItem.ORIENTATION_DEGREE, display.getOrientationDegree())),
                ScreenInfo(Item(ScreenItem.DIAGONAL_SIZE, metrics.getScreenInch().toString())),
                ScreenInfo(Item(ScreenItem.X_DPI, metrics.xdpi.toString())),
                ScreenInfo(Item(ScreenItem.Y_DPI, metrics.ydpi.toString()))
            )

    }

}