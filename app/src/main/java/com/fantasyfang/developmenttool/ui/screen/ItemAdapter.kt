package com.fantasyfang.developmenttool.ui.screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fantasyfang.developmenttool.data.ScreenInfo
import com.fantasyfang.developmenttool.databinding.ItemScreenBinding

class ItemAdapter(var listItems: List<ScreenInfo> = listOf()) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private lateinit var binding: ItemScreenBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemScreenBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.updateContent(listItems[position])
    }

    fun updateList(listItems: List<ScreenInfo>) {
        this.listItems = listItems
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val itemScreenBinding: ItemScreenBinding) :
        RecyclerView.ViewHolder(itemScreenBinding.root) {
        fun updateContent(screenInfo: ScreenInfo) {
            itemScreenBinding.titleText.text = screenInfo.item.name.name
            itemScreenBinding.valueText.text = screenInfo.item.value
        }
    }

}