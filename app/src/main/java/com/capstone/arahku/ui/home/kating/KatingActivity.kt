package com.capstone.arahku.ui.home.kating

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.UniversityAdapter
import com.capstone.arahku.databinding.ActivityKatingBinding
import com.capstone.arahku.model.source.DummyDataSource
import com.capstone.arahku.model.source.University

class KatingActivity : AppCompatActivity(), UniversityAdapter.OnItemClickListener {

    private lateinit var binding: ActivityKatingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKatingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Kating"

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = UniversityAdapter(DummyDataSource.universityList)
        adapter.setOnItemClickListener(this)
        binding.apply {
            rvUniversity.adapter = adapter
            rvUniversity.layoutManager = LinearLayoutManager(this@KatingActivity)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onItemClick(university: University) {
        val intent = Intent(this, DetailKatingActivity::class.java)
        intent.putExtra("university", university)
        startActivity(intent)
    }
}