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
import com.fantasyfang.developmenttool.repository.Result
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
            ScreenInfo(
                Item(
                    ScreenItem.REFRESH_RATE,
                    Result.Success(display.refreshRate.roundToInt().toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.WIDTH_PX,
                    Result.Success(metricsScreen.widthPixels.toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.HEIGHT_PX,
                    Result.Success(metricsScreen.heightPixels.toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.USABLE_WIDTH_PX,
                    Result.Success(metrics.widthPixels.toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.USABLE_HEIGHT_PX,
                    Result.Success(metrics.heightPixels.toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.DENSITY,
                    Result.Success(((metrics.density * 10.0).roundToInt() / 10.0).toString())
                )
            ),
            ScreenInfo(Item(ScreenItem.DENSITY_DPI, Result.Success(metrics.densityDpi.toString()))),
            ScreenInfo(
                Item(
                    ScreenItem.DRAWABLE_DENSITY,
                    Result.Success(context.resources.getString(R.string.screen_density_value))
                )
            ),

            ScreenInfo(
                Item(
                    ScreenItem.LAYOUT_SIZE,
                    Result.Success(context.getLayoutSize(display, metrics))
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.WIDTH_DP, Result.Success(metricsScreen.getWidthDP().toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.HEIGHT_DP, Result.Success(metricsScreen.getHeightDP().toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.SMALL_DP,
                    Result.Success(
                        min(
                            metricsScreen.getHeightDP(),
                            metricsScreen.getWidthDP()
                        ).toString()
                    )
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.ORIENTATION,
                    Result.Success(display.getOrientationString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.ORIENTATION_DEGREE,
                    Result.Success(display.getOrientationDegree())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.DIAGONAL_SIZE,
                    Result.Success(metrics.getScreenInch().toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.X_DPI,
                    Result.Success(((metrics.xdpi * 10).roundToInt() / 10.0).toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.Y_DPI,
                    Result.Success(((metrics.ydpi * 10).roundToInt() / 10.0).toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.STATUS_BAR_HEIGHT,
                    Result.Success(context.getStatusBarHeight().toString())
                )
            ),
            ScreenInfo(
                Item(
                    ScreenItem.NAVIGATION_BAR_HEIGHT,
                    Result.Success(context.getNavigationBarHeight().toString())
                )
            )
        )
    }

}