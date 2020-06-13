package com.fantasyfang.developmenttool.repository.screen

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import com.fantasyfang.developmenttool.R
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

        val metricsScreen = DisplayMetrics()
        display.getRealMetrics(metricsScreen)

        val metrics = DisplayMetrics()
        display.getMetrics(metrics)

        return listOf(
            ScreenInfo(Item(ScreenItem.REFRESH_RATE, display.refreshRate.roundToInt().toString())),
            ScreenInfo(
                Item(
                    ScreenItem.WIDTH_PX,
                    metricsScreen.widthPixels.toString()
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.HEIGHT_PX,
                    metricsScreen.heightPixels.toString()
                )
            ),
            ScreenInfo(Item(ScreenItem.USABLE_WIDTH_PX, metrics.widthPixels.toString())),
            ScreenInfo(Item(ScreenItem.USABLE_HEIGHT_PX, metrics.heightPixels.toString())),
            ScreenInfo(
                Item(
                    ScreenItem.DENSITY,
                    ((metrics.density * 10.0).roundToInt() / 10.0).toString()
                )
            ),
            ScreenInfo(Item(ScreenItem.DENSITY_DPI, metrics.densityDpi.toString())),
            ScreenInfo(
                Item(
                    ScreenItem.DRAWABLE_DENSITY,
                    context.resources.getString(R.string.screen_density_value)
                )
            ),

            ScreenInfo(
                Item(
                    ScreenItem.LAYOUT_SIZE,
                    context.getLayoutSize(display, metrics)
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.WIDTH_DP, metricsScreen.getWidthDP().toString()
                )
            ),
            ScreenInfo(
                Item(ScreenItem.HEIGHT_DP, metricsScreen.getHeightDP().toString())
            ),

            ScreenInfo(
                Item(
                    ScreenItem.SMALL_DP,
                    min(metricsScreen.getHeightDP(), metricsScreen.getWidthDP()).toString()
                )
            ),
            ScreenInfo(Item(ScreenItem.ORIENTATION, display.getOrientationString())),
            ScreenInfo(Item(ScreenItem.ORIENTATION_DEGREE, display.getOrientationDegree())),
            ScreenInfo(Item(ScreenItem.DIAGONAL_SIZE, metrics.getScreenInch().toString())),
            ScreenInfo(
                Item(
                    ScreenItem.X_DPI,
                    ((metrics.xdpi * 10).roundToInt() / 10.0).toString()
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.Y_DPI,
                    ((metrics.ydpi * 10).roundToInt() / 10.0).toString()
                )
            ),
            ScreenInfo(Item(ScreenItem.STATUS_BAR_HEIGHT, context.getStatusBarHeight().toString())),
            ScreenInfo(
                Item(
                    ScreenItem.NAVIGATION_BAR_HEIGHT,
                    context.getNavigationBarHeight().toString()
                )
            )
        )
    }

}