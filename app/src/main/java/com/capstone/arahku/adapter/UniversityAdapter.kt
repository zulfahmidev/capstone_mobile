package com.capstone.arahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemUniversityBinding
import com.capstone.arahku.model.source.University

class UniversityAdapter(private val universityList: List<University>): RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): UniversityAdapter.ViewHolder {
        return ViewHolder(
            ItemUniversityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UniversityAdapter.ViewHolder, position: Int) {
        val listUniversity = universityList[position]
        holder.bind(listUniversity)
    }

    override fun getItemCount() = universityList.size

    inner class ViewHolder(private val binding: ItemUniversityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val university = universityList[position]
                    onItemClickListener?.onItemClick(university)
                }
            }
        }
        fun bind(university: University) {
            with(binding) {
                tvUniversity.text = university.name
                ivUniversity.setImageResource(university.image)
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(university: University)
    }

}