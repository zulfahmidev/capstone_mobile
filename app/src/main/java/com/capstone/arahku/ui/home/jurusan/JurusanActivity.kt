package com.capstone.arahku.ui.home.jurusan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.arahku.databinding.ActivityJurusanBinding

class JurusanActivity : AppCompatActivity() {

    private var binding : ActivityJurusanBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJurusanBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Jurusan"

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}