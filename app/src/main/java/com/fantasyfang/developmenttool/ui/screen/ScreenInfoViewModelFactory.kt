package com.fantasyfang.developmenttool.ui.screen

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.data.ScreenUIInfo
import com.fantasyfang.developmenttool.di.ViewModelAssistedFactory
import com.fantasyfang.developmenttool.repository.InfoRepository
import javax.inject.Inject

class ScreenInfoViewModelFactory @Inject constructor(
    private val screenInfoRepository: InfoRepository<ScreenUIInfo>
) : ViewModelAssistedFactory<ScreenInfoViewModel> {

    override fun create(handle: SavedStateHandle): ScreenInfoViewModel =
        ScreenInfoViewModel(handle, screenInfoRepository)
}