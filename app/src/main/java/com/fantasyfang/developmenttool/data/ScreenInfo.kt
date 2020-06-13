package com.fantasyfang.developmenttool.data

import com.fantasyfang.developmenttool.R

data class ScreenInfo(val item: Item<ScreenItem, String>) : InfoBase {
    override fun getStringId(): Int = item.name.value

    override fun getValue(): String = item.value
}

enum class ScreenItem(val value: Int) {
    REFRESH_RATE(R.string.screen_fresh_rate),
    WIDTH_PX(R.string.screen_width_px),
    HEIGHT_PX(R.string.screen_height_px),
    USABLE_WIDTH_PX(R.string.screen_usable_width_px),
    USABLE_HEIGHT_PX(R.string.screen_usable_height_px),
    DENSITY(R.string.screen_density),
    DENSITY_DPI(R.string.screen_screen_dpi),
    DRAWABLE_DENSITY(R.string.screen_drawable_density),
    LAYOUT_SIZE(R.string.screen_layout_size),
    WIDTH_DP(R.string.screen_width_dp),
    HEIGHT_DP(R.string.screen_height_dp),
    SMALL_DP(R.string.screen_small_dp),
    ORIENTATION(R.string.screen_orientation),
    ORIENTATION_DEGREE(R.string.screen_orientation_degree),
    DIAGONAL_SIZE(R.string.screen_diagonal_size),
    X_DPI(R.string.screen_x_dpi),
    Y_DPI(R.string.screen_y_dpi),
    STATUS_BAR_HEIGHT(R.string.screen_status_bar_height),
    NAVIGATION_BAR_HEIGHT(R.string.screen_navigation_bar_height)
}

enum class ScreenOrientationItem(val value: String) {
    ORIENTATION_PORTRAIT("Portrait"),
    ORIENTATION_LANDSCAPE("Landscape"),
}