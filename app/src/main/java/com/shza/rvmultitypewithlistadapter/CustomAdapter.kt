package com.shza.rvmultitypewithlistadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.shza.rvmultitypewithlistadapter.databinding.ItemAddBinding
import com.shza.rvmultitypewithlistadapter.databinding.ItemImageBinding


class CustomAdapter: ListAdapter<Portfolio, CustomAdapter.CustomViewHolder>(PortfolioItemDiffCallback()) {

    sealed class CustomViewHolder(binding: ViewBinding): RecyclerView.ViewHolder(binding.root) {

        class AddViewHolder(private val binding: ItemAddBinding): CustomViewHolder(binding) {
            fun bind(item: Portfolio.Add) {
                binding.addName.text = item.name
            }
        }

        class ImageViewHolder(private val binding: ItemImageBinding): CustomViewHolder(binding) {
            fun bind(itemImage: Portfolio.Image){
                binding.imageName.text = itemImage.name
            }
        }
    }

    class PortfolioItemDiffCallback: DiffUtil.ItemCallback<Portfolio>() {
        override fun areItemsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Portfolio, newItem: Portfolio): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return when(viewType) {
            R.layout.item_add -> CustomViewHolder.AddViewHolder(ItemAddBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            R.layout.item_image -> CustomViewHolder.ImageViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid ViewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        when(holder) {
            is CustomViewHolder.AddViewHolder -> holder.bind(currentList[position] as Portfolio.Add)
            is CustomViewHolder.ImageViewHolder -> holder.bind(currentList[position] as Portfolio.Image)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return R.layout.item_add
        }
        return R.layout.item_image
    }
}