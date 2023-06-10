package com.capstone.arahku.ui.home.university

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.arahku.databinding.ActivityDetailUniversityBinding
import com.capstone.arahku.model.source.University

class DetailUniversityActivity : AppCompatActivity() {

    private var binding: ActivityDetailUniversityBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUniversityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Universitas"

        val university = intent.getSerializableExtra("university") as? University
        university?.let { showDetailUniversity(it) }
    }

    private fun showDetailUniversity(university: University) {
        binding?.apply {
            tvNameUniversity.text = university.name
            tvDetailUniversity.text = university.description
            ivDetailUniversity.setImageResource(university.image)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}