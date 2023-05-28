package com.capstone.arahku.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstone.arahku.databinding.ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        buttonSetup()
    }

    private fun buttonSetup(){
        binding.apply {
            landingBtnLogin.setOnClickListener {
                startActivity(Intent(this@LandingPageActivity, LoginActivity::class.java))
            }
            landingBtnRegister.setOnClickListener {
                startActivity(Intent(this@LandingPageActivity, RegisterActivity::class.java))
            }
        }
    }
}