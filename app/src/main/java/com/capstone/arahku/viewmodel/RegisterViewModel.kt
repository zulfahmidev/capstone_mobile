package com.capstone.arahku.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.arahku.api.ApiConfig
import com.capstone.arahku.model.RegisterBody
import com.capstone.arahku.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel: ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun register(registerBody: RegisterBody){
        _isLoading.value = true
        val client = ApiConfig.getApiService().register(registerBody)
        client.enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful){
                    val responseBody = response.body()
                    Log.d("RegisterActivity", responseBody?.message.toString())
                    _status.value = true
                }else{
                    _status.value = false
                    Log.e("RegisterActivity", "onFailure: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                _isLoading.value = false
                _status.value = false
                Log.e("RegisterActivity", "onFailure: ${t.message}")
            }
        })
    }

}