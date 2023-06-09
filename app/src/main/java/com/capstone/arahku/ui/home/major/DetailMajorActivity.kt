package com.capstone.arahku.ui.home.major

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.arahku.databinding.ActivityDetailMajorBinding
import com.capstone.arahku.model.source.Major

class DetailMajorActivity : AppCompatActivity() {

    private var binding: ActivityDetailMajorBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMajorBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Jurusan"

        val major = intent.getSerializableExtra("major") as? Major
        major?.let { showDetailMajor(it) }
    }

    private fun showDetailMajor(major: Major) {
        binding?.apply {
            tvMajorName.text = major.name
            tvMajorDescription.text = major.description
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}