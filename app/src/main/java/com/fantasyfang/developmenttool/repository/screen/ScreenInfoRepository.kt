package com.fantasyfang.developmenttool.repository.screen

import com.fantasyfang.developmenttool.data.ScreenUIInfo

interface ScreenInfoRepository {
    fun getScreenInfo(): ScreenUIInfo
}