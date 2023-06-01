package com.capstone.arahku.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.MainActivity
import com.capstone.arahku.R
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.viewmodel.LoginViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
        )

        val pref = UserPreference.getInstance(dataStore)
        viewmodel = ViewModelProvider(this, ViewModelFactory(pref))[LoginViewModel::class.java]

        Handler(Looper.getMainLooper()).postDelayed({
            viewmodel.getState().observe(this@SplashScreenActivity){ isLogin ->
                if (isLogin){
                    startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                    finish()
                }else{
                    startActivity(Intent(this@SplashScreenActivity, LandingPageActivity::class.java))
                    finish()
                }
            }
        }, 3000)

    }
}