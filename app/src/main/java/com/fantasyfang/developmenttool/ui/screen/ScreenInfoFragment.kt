package com.fantasyfang.developmenttool.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.databinding.ScreenInfoFragmentBinding
import com.fantasyfang.developmenttool.utilities.InjectorUtils

class ScreenInfoFragment() : Fragment() {

    companion object {
        fun newInstance() = ScreenInfoFragment()
    }

    private var _binding: ScreenInfoFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ScreenInfoViewModel by viewModels {
        InjectorUtils.getScreenInfoViewModelFactory(
            requireActivity()
        )
    }

    private lateinit var itemAdapter: ItemAdapter<ScreenInfo>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ScreenInfoFragmentBinding.inflate(inflater, container, false)
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
        viewModel.getScreenInfos().observe(viewLifecycleOwner, Observer {
            itemAdapter.updateList(it.list)
        })
    }

    private fun setUpRecyclerView() {
        with(binding.screenRecyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = ItemAdapter<ScreenInfo>().apply {
                itemAdapter = this
            }
        }
    }

}
