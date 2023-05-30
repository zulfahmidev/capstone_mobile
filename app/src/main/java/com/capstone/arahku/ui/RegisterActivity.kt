package com.capstone.arahku.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.R
import com.capstone.arahku.databinding.ActivityRegisterBinding
import com.capstone.arahku.model.RegisterBody
import com.capstone.arahku.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.apply {
            textButton.setOnClickListener {
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }
        }

        viewModelSetup()
        registerSetup()
    }

    private fun viewModelSetup(){
        registerViewModel = ViewModelProvider(this@RegisterActivity)[RegisterViewModel::class.java]
    }

    private fun registerSetup(){
        binding.btnRegister.setOnClickListener {
            val name = binding.edRegisterName.text.toString()
            val email = binding.edRegisterEmail.text.toString()
            val password = binding.edRegisterPassword.text.toString()
            val phone = binding.edRegisterTelephone.text.toString()
            val address = binding.edRegisterAddress.text.toString()
            val date = binding.edRegisterBirth.text.toString()

            val body = RegisterBody(
                name = name,
                email = email,
                password = password,
                phone = phone,
                address = address,
                birthDate = date)

            when{
                name.isEmpty() ->{
                    binding.edRegisterName.error = getString(R.string.empty_field_error)
                }
                email.isEmpty() -> {
                    binding.edRegisterEmail.error = getString(R.string.empty_field_error)
                }
                password.isEmpty() -> {
                    binding.edRegisterPassword.error = getString(R.string.empty_field_error)
                }
                phone.isEmpty() -> {
                    binding.edRegisterTelephone.error = getString(R.string.empty_field_error)
                }
                address.isEmpty() -> {
                    binding.edRegisterAddress.error = getString(R.string.empty_field_error)
                }
                password.isEmpty() -> {
                    binding.edRegisterPassword.error = getString(R.string.empty_field_error)
                }
                else -> {
                    registerViewModel.register(body)
                }
            }
        }

        registerViewModel.status.observe(this@RegisterActivity){success ->
            if (success){
                Toast.makeText(this@RegisterActivity, getString(R.string.register_success_message), Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, LandingPageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@RegisterActivity, getString(R.string.register_failure_message)
                    , Toast.LENGTH_SHORT).show()
            }
        }
    }
}