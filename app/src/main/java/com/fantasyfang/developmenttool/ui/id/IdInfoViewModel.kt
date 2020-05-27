package com.fantasyfang.developmenttool.ui.id

import androidx.lifecycle.SavedStateHandle
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.repository.InfoRepository
import com.fantasyfang.developmenttool.ui.base.BaseInfoViewModel

class IdInfoViewModel(
    private val savedStateHandle: SavedStateHandle,
    idInfoRepository: InfoRepository<List<IdInfo>>
) : BaseInfoViewModel<List<IdInfo>>(idInfoRepository)