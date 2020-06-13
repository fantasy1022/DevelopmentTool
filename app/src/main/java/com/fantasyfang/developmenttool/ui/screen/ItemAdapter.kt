package com.fantasyfang.developmenttool.ui.screen

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fantasyfang.developmenttool.data.InfoBase
import com.fantasyfang.developmenttool.databinding.ItemInfoBinding

class ItemAdapter<T : InfoBase>(var listItems: List<T> = listOf()) :
    RecyclerView.Adapter<ItemAdapter<T>.ItemViewHolder>() {
    private lateinit var binding: ItemInfoBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.updateContent(listItems[position])
    }

    fun updateList(listItems: List<T>) {
        this.listItems = listItems
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val itemScreenBinding: ItemInfoBinding) :
        RecyclerView.ViewHolder(itemScreenBinding.root) {
        var res: Resources = itemScreenBinding.root.resources

        fun updateContent(t: T) {
            itemScreenBinding.titleText.text = res.getString(t.getStringId())
            itemScreenBinding.valueText.text = t.getValue()
        }
    }

}