package com.capstone.arahku.ui.home.test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ContentInfoCompat
import com.capstone.arahku.MainActivity
import com.capstone.arahku.R
import com.capstone.arahku.databinding.ActivityTestResultBinding
import com.capstone.arahku.ui.home.major.MajorActivity

class TestResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val major = intent.getStringExtra("result")
        val user = intent.getStringExtra("username")

        binding.apply {
            textResult.text = getString(R.string.result_text, user)
            majorResult.text = major

            btnKembali.setOnClickListener {
                val intent = Intent(this@TestResultActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }

            btnMore.setOnClickListener {
                val intent = Intent(this@TestResultActivity, MajorActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }

    }
}