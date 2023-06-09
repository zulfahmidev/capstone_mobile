package com.capstone.arahku.ui.home.friend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.ClosestFriendAdapter
import com.capstone.arahku.databinding.ActivityClosestFriendBinding
import com.capstone.arahku.model.source.DummyDataSource

class ClosestFriendActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClosestFriendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClosestFriendBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Teman Dekat"

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = ClosestFriendAdapter(DummyDataSource.friendList)
        binding.apply {
            rvFriends.adapter = adapter
            rvFriends.layoutManager = LinearLayoutManager(this@ClosestFriendActivity)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}