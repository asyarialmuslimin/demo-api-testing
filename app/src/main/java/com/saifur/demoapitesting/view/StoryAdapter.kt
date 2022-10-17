package com.saifur.demoapitesting.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saifur.demoapitesting.data.remote.response.PostResponseItem
import com.saifur.demoapitesting.databinding.ItemStoryBinding

class StoryAdapter : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    private val itemList = arrayListOf<PostResponseItem>()

    fun setData(items: List<PostResponseItem>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostResponseItem) {
            with(binding) {
                txtTitle.text = item.title
                txtDescription.text = item.body
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}