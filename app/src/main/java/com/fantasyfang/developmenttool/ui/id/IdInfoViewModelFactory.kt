package com.fantasyfang.developmenttool.ui.id

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.di.ViewModelAssistedFactory
import com.fantasyfang.developmenttool.repository.InfoRepository
import javax.inject.Inject

class IdInfoViewModelFactory @Inject constructor(
    private val idInfoRepository: InfoRepository<List<IdInfo>>
) : ViewModelAssistedFactory<IdInfoViewModel> {

    override fun create(handle: SavedStateHandle): IdInfoViewModel =
        IdInfoViewModel(handle, idInfoRepository)

}