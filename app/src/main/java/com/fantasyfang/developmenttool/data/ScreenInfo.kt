package com.fantasyfang.developmenttool.data

import com.fantasyfang.developmenttool.R

data class ScreenUIInfo(val list: List<ScreenInfo>)

data class ScreenInfo(val item: Item<ScreenItem, String>)

enum class ScreenItem(val value: Int) {
    REFRESH_RATE(R.string.screen_fresh_rate),
    WIDTH(R.string.screen_width_px),
    HEIGHT(R.string.screen_height_px),
}