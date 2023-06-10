package com.capstone.arahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemKatingBinding
import com.capstone.arahku.model.source.Kating

class KatingAdapter(private val katingList: List<Kating>): RecyclerView.Adapter<KatingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): KatingAdapter.ViewHolder {
        return ViewHolder(
            ItemKatingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listKating = katingList[position]
        holder.bind(listKating)
    }

    override fun getItemCount() = katingList.size

    inner class ViewHolder(private val binding: ItemKatingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(kating: Kating) {
            with(binding) {
                tvKating.text = kating.name
                tvSemester.text = kating.semester
                ivKating.setImageResource(kating.image)
            }
        }
    }
}