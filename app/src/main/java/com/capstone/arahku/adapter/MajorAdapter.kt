package com.capstone.arahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemMajorBinding
import com.capstone.arahku.model.response.MajorData

class MajorAdapter(private val listMajor: List<MajorData>) :
    RecyclerView.Adapter<MajorAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMajorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = listMajor.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val major = listMajor[position]
        with(holder.binding) {
            tvMajor.text = major.name
            root.setOnClickListener { onItemClickCallback.onItemClicked(listMajor[position]) }
        }
    }

    inner class ViewHolder(var binding: ItemMajorBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MajorData)
    }
}