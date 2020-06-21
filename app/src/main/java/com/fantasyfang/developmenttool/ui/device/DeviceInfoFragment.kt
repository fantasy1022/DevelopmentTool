package com.fantasyfang.developmenttool.ui.device

import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.di.GenericSavedStateViewModelFactory
import com.fantasyfang.developmenttool.ui.base.BaseInfoFragment
import javax.inject.Inject

class DeviceInfoFragment : BaseInfoFragment<DeviceInfo>() {

    companion object {
        fun newInstance() = DeviceInfoFragment()
    }

    @Inject
    lateinit var viewModelFactory: DeviceInfoViewModelFactory

    private val viewModel: DeviceInfoViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            viewModelFactory,
            this
        )
    }

    override fun getMutableLiveData(): LiveData<List<DeviceInfo>> //: MutableLiveData<List<DeviceInfo>>
            = viewModel.getInfo()

}
