package com.fantasyfang.developmenttool.ui.device

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.databinding.DeviceInfoFragmentBinding
import com.fantasyfang.developmenttool.di.GenericSavedStateViewModelFactory
import com.fantasyfang.developmenttool.ui.screen.ItemAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DeviceInfoFragment : DaggerFragment() {

    companion object {
        fun newInstance() = DeviceInfoFragment()
    }

    private var _binding: DeviceInfoFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: DeviceInfoViewModelFactory

    private val viewModel: DeviceInfoViewModel by viewModels {
        GenericSavedStateViewModelFactory(
            viewModelFactory,
            this
        )
    }

    private lateinit var itemAdapter: ItemAdapter<DeviceInfo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DeviceInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fetchData() {
        viewModel.getDeviceInfo().observe(viewLifecycleOwner, Observer {
            itemAdapter.updateList(it.list)
        })
    }

    private fun setUpRecyclerView() {
        with(binding.deviceRecyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = ItemAdapter<DeviceInfo>().apply {
                itemAdapter = this
            }
        }
    }

}
