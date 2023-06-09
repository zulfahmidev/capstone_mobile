package com.capstone.arahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemMajorBinding
import com.capstone.arahku.model.source.Major

class MajorAdapter(private val majorList: List<Major>): RecyclerView.Adapter<MajorAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMajorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = majorList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listMajor = majorList[position]
        holder.bind(listMajor)

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(listMajor)
        }
    }

    inner class ViewHolder(private val binding: ItemMajorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(major: Major) {
            with(binding) {
                tvMajor.text = major.name
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(major: Major)
    }
}