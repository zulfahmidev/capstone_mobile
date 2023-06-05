package com.capstone.arahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemMenuTestBinding
import com.capstone.arahku.model.source.MenuTest

class MenuTestAdapter(
    private val menuTestList: List<MenuTest>) :
    RecyclerView.Adapter<MenuTestAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMenuTestBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listMenuTest = menuTestList[position]
        holder.bind(listMenuTest)

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(listMenuTest)
        }
    }

    override fun getItemCount() = menuTestList.size

    inner class ViewHolder(private val binding: ItemMenuTestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuTest: MenuTest) {
            with(binding) {
                tvNameTest.text = menuTest.name
                tvShortDescTest.text = menuTest.description
                ivImgTest.setImageResource(menuTest.image)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(menuTest: MenuTest)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }
}