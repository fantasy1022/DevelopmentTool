package com.fantasyfang.developmenttool.ui.device

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fantasyfang.developmenttool.data.DeviceInfo
import com.fantasyfang.developmenttool.databinding.DeviceInfoFragmentBinding
import com.fantasyfang.developmenttool.ui.screen.ItemAdapter
import com.fantasyfang.developmenttool.utilities.InjectorUtils

class DeviceInfoFragment : Fragment() {

    companion object {
        fun newInstance() = DeviceInfoFragment()
    }

    private var _binding: DeviceInfoFragmentBinding? = null
    private val binding get() = _binding!!

    private val activityContext get() = activity!!

    private lateinit var viewModel: DeviceInfoViewModel
    private lateinit var itemAdapter: ItemAdapter<DeviceInfo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = InjectorUtils.getDeviceInfoViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(DeviceInfoViewModel::class.java)
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
        viewModel.getDeviceInfo().observe(this, Observer {
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
