package com.fantasyfang.developmenttool.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fantasyfang.developmenttool.databinding.DeviceInfoFragmentBinding

class DeviceInfoFragment : Fragment() {

    companion object {
        fun newInstance() = DeviceInfoFragment()
    }

    private var _binding: DeviceInfoFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DeviceInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DeviceInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DeviceInfoViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
