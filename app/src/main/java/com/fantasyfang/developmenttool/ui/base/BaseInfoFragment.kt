package com.fantasyfang.developmenttool.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.fantasyfang.developmenttool.data.InfoBase
import com.fantasyfang.developmenttool.databinding.BaseInfoFragmentBinding
import com.fantasyfang.developmenttool.repository.LackPermission
import dagger.android.support.DaggerFragment


abstract class BaseInfoFragment<T : InfoBase> : DaggerFragment(), ItemAdapter.ItemClickListener {

    private lateinit var itemAdapter: ItemAdapter<T>
    private var _binding: BaseInfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = BaseInfoFragmentBinding.inflate(inflater, container, false)
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

    override fun onItemClickPermission(permission: LackPermission) {
        //Do nothing
    }

    override fun onItemClickException(exception: Exception) {
        //Do nothing
    }

    protected fun fetchData() {
        getMutableLiveData().observe(viewLifecycleOwner, Observer {
            itemAdapter.updateList(it)
        })
    }

    private fun setUpRecyclerView() {
        with(binding.baseRecyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = ItemAdapter<T>(itemClickListener = this@BaseInfoFragment).apply {
                itemAdapter = this
            }
        }
    }

    abstract fun getMutableLiveData(): MutableLiveData<List<T>>
}