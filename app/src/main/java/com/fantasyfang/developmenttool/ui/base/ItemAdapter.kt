package com.fantasyfang.developmenttool.ui.base

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fantasyfang.developmenttool.data.InfoBase
import com.fantasyfang.developmenttool.databinding.ItemInfoBinding
import com.fantasyfang.developmenttool.repository.Result

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
            when (t.getValue()) {
                is Result.Success -> {
                    with(itemScreenBinding) {
                        valueText.visibility = View.VISIBLE
                        valueText.text = (t.getValue() as Result.Success).string
                        errorButton.visibility = View.GONE
                    }
                }
                is Result.FailureLackPermission -> {
                    with(itemScreenBinding) {
                        valueText.visibility = View.GONE
                        errorButton.visibility = View.VISIBLE
                        //TODO: Parse permission name
                        //TOOD: Use string with placeHolder
                        errorButton.text =
                            "Get ${(t.getValue() as Result.FailureLackPermission).lackPermission.value}"
                        errorButton.setOnClickListener {
                            //TODO: Use interface to bring permission
                        }
                    }

                }
            }
        }
    }

}