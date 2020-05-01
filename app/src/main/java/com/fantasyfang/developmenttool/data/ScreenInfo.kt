package com.fantasyfang.developmenttool.data

data class ScreenUIInfo(val list: List<ScreenInfo>)

data class ScreenInfo(val item: Item<ScreenItem, String>)

enum class ScreenItem {
    REFRESH_RATE, DIMENSIONS, PIXEL, DENSITY
}