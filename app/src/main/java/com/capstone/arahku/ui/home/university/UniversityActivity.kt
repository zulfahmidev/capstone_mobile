package com.capstone.arahku.ui.home.university

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.UniversityAdapter
import com.capstone.arahku.databinding.ActivityUniversityBinding
import com.capstone.arahku.model.source.DummyDataSource
import com.capstone.arahku.model.source.University

class UniversityActivity : AppCompatActivity(), UniversityAdapter.OnItemClickListener {

    private lateinit var binding: ActivityUniversityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Universitas"

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = UniversityAdapter(DummyDataSource.universityList)
        adapter.setOnItemClickListener(this)
        binding.apply {
            rvUniversity.adapter = adapter
            rvUniversity.layoutManager = LinearLayoutManager(this@UniversityActivity)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onItemClick(university: University) {
        val intent = Intent(this, DetailUniversityActivity::class.java)
        intent.putExtra("university", university)
        startActivity(intent)
    }
}