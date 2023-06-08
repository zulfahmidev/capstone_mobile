package com.capstone.arahku.ui.home.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.capstone.arahku.R
import com.capstone.arahku.databinding.ActivityTestResultBinding

class TestResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val major = intent.getStringExtra("result")
        val user = intent.getStringExtra("username")

        binding.apply {
            textResult.text = getString(R.string.result_text, user)
            majorResult.text = major
        }
    }
}