package com.capstone.arahku.ui.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.capstone.arahku.R
import com.capstone.arahku.databinding.ActivityRegisterBinding
import com.capstone.arahku.model.response.RegisterBody
import com.capstone.arahku.ui.LandingPageActivity
import com.capstone.arahku.viewmodel.RegisterViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

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
        setupEmailValidation()
        setupPasswordValidation()
    }

    private fun viewModelSetup(){
        registerViewModel = ViewModelProvider(this@RegisterActivity)[RegisterViewModel::class.java]
    }


    fun showDatePickerDialog(view: View) {
        val builder = MaterialDatePicker.Builder.datePicker()
        val picker = builder.build()

        picker.addOnPositiveButtonClickListener { selection ->
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selection

            val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            val formattedDate = dateFormat.format(calendar.time)

            binding.edRegisterBirth.setText(formattedDate)
        }

        picker.show(supportFragmentManager, picker.toString())
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
                    binding.nameEditTextLayout.error = getString(R.string.empty_field_error)
                }
                email.isEmpty() -> {
                    binding.emailEditTextLayout.error = getString(R.string.empty_field_error)
                }
                password.isEmpty() -> {
                    binding.passwordEditTextLayout.error = getString(R.string.empty_field_error)
                }
                phone.isEmpty() -> {
                    binding.telephoneEditTextLayout.error = getString(R.string.empty_field_error)
                }
                address.isEmpty() -> {
                    binding.addressEditTextLayout.error = getString(R.string.empty_field_error)
                }
                password.isEmpty() -> {
                    binding.passwordEditTextLayout.error = getString(R.string.empty_field_error)
                }
                else -> {
                    registerViewModel.register(body)

                }
            }
        }

        registerViewModel.status.observe(this@RegisterActivity){success ->
            val builder = AlertDialog.Builder(this@RegisterActivity)
            if (success){
                builder.setIcon(R.drawable.notification)
                    .setTitle("Pendaftaran Berhasil!")
                    .setMessage(R.string.register_success_message)
                    .setPositiveButton("Ya"){_, _ ->
                        startActivity(Intent(this@RegisterActivity, LandingPageActivity::class.java))
                        finish()
                    }
                    .show()
            }else{
                builder.setIcon(R.drawable.notification)
                    .setTitle("Pendaftaran Gagal!")
                    .setMessage(R.string.register_failure_message)
                    .setNegativeButton("Ya", null)
                    .show()
            }
        }

        registerViewModel.isLoading.observe(this@RegisterActivity){isLoading ->
            showLoading(isLoading)
        }
    }

    private fun setupEmailValidation() {
        binding.edRegisterEmail.addTextChangedListener(object : TextWatcher {
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
        binding.edRegisterPassword.addTextChangedListener(object : TextWatcher{
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

    private fun showLoading(isLoading: Boolean){
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}