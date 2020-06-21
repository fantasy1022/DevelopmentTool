package com.fantasyfang.developmenttool.ui.screen

import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.di.GenericSavedStateViewModelFactory
import com.fantasyfang.developmenttool.ui.base.BaseInfoFragment
import javax.inject.Inject

class ScreenInfoFragment() : BaseInfoFragment<ScreenInfo>() {

    companion object {
        fun newInstance() = ScreenInfoFragment()
    }

    @Inject
    lateinit var viewModelFactory: ScreenInfoViewModelFactory

    private val viewModel: ScreenInfoViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            viewModelFactory,
            this
        )
    }

    override fun getMutableLiveData(): LiveData<List<ScreenInfo>> =
        viewModel.getInfo()
}
