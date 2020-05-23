package com.fantasyfang.developmenttool.ui.screen

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.repository.InfoRepository
import com.fantasyfang.developmenttool.ui.base.BaseInfoViewModel

class ScreenInfoViewModel(
    private val savedStateHandle: SavedStateHandle,
    screenInfoRepository: InfoRepository<List<ScreenInfo>>
) : BaseInfoViewModel<List<ScreenInfo>>(screenInfoRepository)
