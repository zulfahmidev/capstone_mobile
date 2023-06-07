package com.capstone.arahku.ui.home.jurusan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.arahku.databinding.ActivityMajorBinding

class MajorActivity : AppCompatActivity() {

    private var _binding: ActivityMajorBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMajorBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Jurusan"

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}