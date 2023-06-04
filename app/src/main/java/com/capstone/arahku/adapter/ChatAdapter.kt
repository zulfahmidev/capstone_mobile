package com.capstone.arahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemChatBinding
import com.capstone.arahku.model.source.Chat

class ChatAdapter(private val chatList: List<Chat>) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listChat = chatList[position]
        holder.bind(listChat)
    }

    override fun getItemCount() = chatList.size

    inner class ViewHolder(private val binding: ItemChatBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat) {
            with(binding) {
                tvNameChat.text = chat.name
                tvTeksChat.text = chat.text
                tvTime.text = chat.time
                ivUserChat.setImageResource(chat.image)
                ivVerified.setImageResource(chat.icon)
            }
        }
    }
}