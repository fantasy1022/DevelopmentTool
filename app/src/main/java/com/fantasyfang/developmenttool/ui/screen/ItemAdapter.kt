package com.fantasyfang.developmenttool.ui.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fantasyfang.developmenttool.databinding.ItemScreenBinding

class ItemAdapter() : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private lateinit var binding: ItemScreenBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemScreenBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}