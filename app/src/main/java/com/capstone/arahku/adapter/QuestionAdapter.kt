package com.capstone.arahku.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemQuestionBinding
import com.capstone.arahku.model.response.FieldsItemForm

class QuestionAdapter(private val listQuestion: List<FieldsItemForm?>?) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    class ViewHolder(private val context: Context, private val binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(fieldsItem: FieldsItemForm){
            binding.radioGroup.removeAllViews()
            for (rbt in fieldsItem.options!!) {
                val rb = RadioButton(context)
                rb.text = rbt?.value
                rb.id = rbt?.id!!
                binding.radioGroup.addView(rb)

                rb.setOnClickListener{
                    rb.isChecked = fieldsItem.selectedOptionId == rb.id
                }

                rb.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        fieldsItem.selectedOptionId = buttonView.id
                    }
                }
            }

            binding.apply {
                tvQuestion.text = fieldsItem.label
                tvQuestion.id = fieldsItem?.id!!
            }
            print(binding.tvQuestion.id)
            Log.d("Adapter", "question.id ${binding.tvQuestion.id}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fieldsItem = listQuestion?.get(position)
        fieldsItem?.let { holder.bind(it) }

    }

    override fun getItemCount(): Int = listQuestion?.size!!

    fun getItems(): List<FieldsItemForm?>? {
        return listQuestion
    }

    override fun getItemId(position: Int): Long {
        val fieldsItem = listQuestion?.get(position)
        return fieldsItem?.id?.hashCode()?.toLong() ?: 0
    }

}