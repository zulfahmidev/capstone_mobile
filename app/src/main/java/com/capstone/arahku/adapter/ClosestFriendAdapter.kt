package com.capstone.arahku.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.arahku.databinding.ItemFriendsBinding
import com.capstone.arahku.model.source.Friends

class ClosestFriendAdapter(private val friendList: List<Friends>): RecyclerView.Adapter<ClosestFriendAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFriendsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listFriend = friendList[position]
        holder.bind(listFriend)

    }

    override fun getItemCount() = friendList.size

    inner class ViewHolder(private val binding: ItemFriendsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(friend: Friends) {
            with(binding) {
                tvNameFriend.text = friend.name
                tvDistanceFriend.text = friend.distance
                ivClosestFriend.setImageResource(friend.image)
            }
        }
    }

}