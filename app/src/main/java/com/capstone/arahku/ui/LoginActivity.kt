package com.capstone.arahku.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.MainActivity
import com.capstone.arahku.R
import com.capstone.arahku.databinding.ActivityLoginBinding
import com.capstone.arahku.model.LoginBody
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.viewmodel.LoginViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.textButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        viewModelSetup()
        loginSetup()
    }

    private fun viewModelSetup(){
        val pref = UserPreference.getInstance(dataStore)
        loginViewModel = ViewModelProvider(this, ViewModelFactory(pref))[LoginViewModel::class.java]
    }

    private fun loginSetup(){
        binding.btnLogin.setOnClickListener {
            val email = binding.edLoginEmail.text.toString()
            val password = binding.edLoginPassword.text.toString()

            val loginBody = LoginBody(
                email = email,
                password = password
            )

            when{
                email.isEmpty() -> {
                    binding.edLoginEmail.error = getString(R.string.empty_field_error)
                }
                password.isEmpty() -> {
                    binding.edLoginPassword.error = getString(R.string.empty_field_error)
                }
                else -> {
                    loginViewModel.apply {
                        login(loginBody)
                        isLogin()
                    }
                }
            }
        }

        loginViewModel.status.observe(this@LoginActivity){success ->
            if (success){
                Toast.makeText(this@LoginActivity, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@LoginActivity, "Login Gagal, silahkan coba lagi", Toast.LENGTH_SHORT).show()
            }
        }
    }

}