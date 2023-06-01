package com.capstone.arahku.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.databinding.ActivityLandingPageBinding
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.viewmodel.LoginViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory

class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        buttonSetup()
        viewModelSetup()
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

    private fun viewModelSetup(){
        val pref = UserPreference.getInstance(dataStore)
        viewModel = ViewModelProvider(this, ViewModelFactory(pref))[LoginViewModel::class.java]

//        viewModel.getState().observe(this@LandingPageActivity){ isLogin ->
//            if (isLogin){
//                startActivity(Intent(this@LandingPageActivity, MainActivity::class.java))
//                finish()
//            }
//        }
    }
}