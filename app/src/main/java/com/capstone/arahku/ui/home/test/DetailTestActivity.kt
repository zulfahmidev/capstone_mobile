package com.capstone.arahku.ui.home.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.arahku.databinding.ActivityDetailTestBinding

class DetailTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}