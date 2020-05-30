package com.fantasyfang.developmenttool.ui.id

import android.Manifest
import android.content.pm.PackageManager
import androidx.annotation.RequiresPermission
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import com.fantasyfang.developmenttool.data.IdInfo
import com.fantasyfang.developmenttool.di.GenericSavedStateViewModelFactory
import com.fantasyfang.developmenttool.ui.base.BaseInfoFragment
import javax.inject.Inject

class IdInfoFragment : BaseInfoFragment<IdInfo>() {

    companion object {
        fun newInstance() = IdInfoFragment()
        const val PERMISSIONS_REQUEST_READ_PHONE_STATE = 100
    }

    @Inject
    lateinit var viewModelFactory: IdInfoViewModelFactory

    private val viewModel: IdInfoViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            viewModelFactory,
            this
        )
    }

    @RequiresPermission(Manifest.permission.READ_PHONE_STATE)
    override fun getMutableLiveData(): MutableLiveData<List<IdInfo>> {
        // TODO: Use UI button to trigger
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                PERMISSIONS_REQUEST_READ_PHONE_STATE
            )
        }
        return viewModel.getInfo()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSIONS_REQUEST_READ_PHONE_STATE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchData()
                }
            }
        }
    }
}