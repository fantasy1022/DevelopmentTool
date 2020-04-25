package com.fantasyfang.developmenttool.ui.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fantasyfang.developmenttool.databinding.ScreenInfoFragmentBinding


class ScreenInfoFragment : Fragment() {

    companion object {
        fun newInstance() = ScreenInfoFragment()
    }

    private var _binding: ScreenInfoFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ScreenInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ScreenInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScreenInfoViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
