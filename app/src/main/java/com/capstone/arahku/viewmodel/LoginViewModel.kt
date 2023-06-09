package com.capstone.arahku.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.capstone.arahku.api.ApiConfig
import com.capstone.arahku.model.*
import com.capstone.arahku.model.response.LoginBody
import com.capstone.arahku.model.response.LoginResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(private val preference: UserPreference): ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> = _status

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private fun saveToken(token: String){
        viewModelScope.launch {
            preference.saveToken(token)
        }
    }

    fun isLogin() = viewModelScope.launch {
        preference.isLogin()
    }

    fun getState(): LiveData<Boolean> {
        return preference.getState().asLiveData()
    }

    fun login(loginBody: LoginBody){
        _isLoading.value = true
        val client = ApiConfig.getApiService().login(loginBody)
        client.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                _isLoading.value = false
                if (response.isSuccessful){
                    val responseBody = response.body()
                    saveToken(responseBody?.data?.accessToken.toString())
                    _status.value = true
                    Log.d("LoginActivity", responseBody?.message.toString())
                }else{
                    _status.value = false
                    Log.e("LoginActivity", "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                _isLoading.value = false
                _status.value = false
                Log.e("LoginActivity", "onFailure: ${t.message}")
            }
        })
    }
}