package com.fantasyfang.developmenttool.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fantasyfang.developmenttool.databinding.ScreenInfoFragmentBinding
import com.fantasyfang.developmenttool.utilities.InjectorUtils


class ScreenInfoFragment() : Fragment() {

    companion object {
        fun newInstance() = ScreenInfoFragment()
    }

    private var _binding: ScreenInfoFragmentBinding? = null
    private val binding get() = _binding!!

    private val activityContext get() = activity!!

    private lateinit var viewModel: ScreenInfoViewModel
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val factory = InjectorUtils.getScreenInfoViewModelFactory(requireActivity())
        viewModel = ViewModelProvider(this, factory).get(ScreenInfoViewModel::class.java)
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
        viewModel.getScreenInfos().observe(this, Observer {
            itemAdapter.updateList(it.list)
        })
    }

    private fun setUpRecyclerView() {
        with(binding.screenRecyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = ItemAdapter().apply {
                itemAdapter = this
            }
        }
    }

}
