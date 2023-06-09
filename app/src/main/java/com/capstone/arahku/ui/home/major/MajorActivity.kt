package com.capstone.arahku.ui.home.major

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.arahku.adapter.MajorAdapter
import com.capstone.arahku.databinding.ActivityMajorBinding
import com.capstone.arahku.model.source.DummyDataSource
import com.capstone.arahku.model.source.Major

class MajorActivity : AppCompatActivity(), MajorAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMajorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMajorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Jurusan"

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = MajorAdapter(DummyDataSource.majorList)
        adapter.setOnItemClickListener(this)
        binding.apply {
            rvMajor.adapter = adapter
            rvMajor.layoutManager = LinearLayoutManager(this@MajorActivity)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onItemClick(major: Major) {
        val intent = Intent(this, DetailMajorActivity::class.java)
        intent.putExtra("major", major)
        startActivity(intent)
    }
}