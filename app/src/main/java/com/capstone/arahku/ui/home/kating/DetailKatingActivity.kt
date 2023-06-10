package com.capstone.arahku.ui.home.kating

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.KatingAdapter
import com.capstone.arahku.databinding.ActivityDetailKatingBinding
import com.capstone.arahku.model.source.University

class DetailKatingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKatingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKatingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Kating"

        initAdapter()
    }

    private fun initAdapter() {
        val university = intent.getSerializableExtra("university") as University
        val katingList = university.katingList

        val adapter = KatingAdapter(katingList)
        binding.apply {
            rvKating.adapter = adapter
            rvKating.layoutManager = LinearLayoutManager(this@DetailKatingActivity)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}