package com.fantasyfang.developmenttool.ui.id

import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.di.GenericSavedStateViewModelFactory
import com.fantasyfang.developmenttool.ui.base.BaseInfoFragment
import javax.inject.Inject

class IdInfoFragment : BaseInfoFragment<IdInfo>() {

    companion object {
        fun newInstance() = IdInfoFragment()
    }

    @Inject
    lateinit var viewModelFactory: IdInfoViewModelFactory

    private val viewModel: IdInfoViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            viewModelFactory,
            this
        )
    }

    override fun getMutableLiveData(): MutableLiveData<List<IdInfo>> =
        viewModel.getInfo()

}