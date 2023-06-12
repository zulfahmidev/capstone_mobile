package com.capstone.arahku.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.MainActivity
import com.capstone.arahku.R
import com.capstone.arahku.databinding.ActivityLoginBinding
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.dataStore
import com.capstone.arahku.model.response.LoginBody
import com.capstone.arahku.viewmodel.LoginViewModel
import com.capstone.arahku.viewmodel.ViewModelFactory
import java.util.regex.Pattern

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
        setupEmailValidation()
        setupPasswordValidation()
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
                    binding.emailEditTextLayout.error = getString(R.string.empty_field_error)
                }
                password.isEmpty() -> {
                    binding.passwordEditTextLayout.error = getString(R.string.empty_field_error)
                }
                else -> {
                    loginViewModel.apply {
                        login(loginBody)
                    }
                }
            }
        }

        loginViewModel.status.observe(this@LoginActivity){success ->
            if (success){
                loginViewModel.isLogin()
                Toast.makeText(this@LoginActivity, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@LoginActivity, "Login Gagal, silahkan coba lagi", Toast.LENGTH_SHORT).show()
            }
        }
        loginViewModel.isLoading.observe(this@LoginActivity){isLoading ->
            showLoading(isLoading)
        }
    }

    private fun showLoading(isLoading: Boolean){
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun setupEmailValidation() {
        binding.edLoginEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val email = s.toString()
                if (!isValidEmail(email)) {
                    binding.emailEditTextLayout.error = getString(R.string.email_validation_error)
                } else {
                    binding.emailEditTextLayout.error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun setupPasswordValidation(){
        binding.edLoginPassword.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val password = s.toString()
                if (password.length < 6) {
                    binding.passwordEditTextLayout.error = getString(R.string.password_validation_error)
                }else{
                    binding.passwordEditTextLayout.error = null
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun isValidEmail(email: String): Boolean {
        val pattern = Pattern.compile("[a-zA-Z\\d._-]+@[a-z]+\\.+[a-z]+")
        return pattern.matcher(email).matches()
    }
}