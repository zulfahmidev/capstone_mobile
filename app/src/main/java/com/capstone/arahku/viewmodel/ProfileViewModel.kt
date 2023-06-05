package com.capstone.arahku.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.capstone.arahku.api.ApiConfig
import com.capstone.arahku.model.response.AccountData
import com.capstone.arahku.model.response.AccountResponse
import com.capstone.arahku.model.UserPreference
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel(private val preference: UserPreference): ViewModel() {
    private val _account = MutableLiveData<AccountData?>()
    val account : LiveData<AccountData?> = _account


    fun logout() = viewModelScope.launch {
        preference.logout()
    }

    fun token(): LiveData<String> {
        return preference.getToken().asLiveData()
    }

    fun getAccount(token: String){
        val client = ApiConfig.getApiService().account(token)
        client.enqueue(object : Callback<AccountResponse>{
            override fun onResponse(
                call: Call<AccountResponse>,
                response: Response<AccountResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    _account.value = responseBody?.data
                }else{
                    Log.e("Profile", "onFailure: ${response.message()}")
                }

            }

            override fun onFailure(call: Call<AccountResponse>, t: Throwable) {
                Log.e("Profile", "onFailure: ${t.message}")
            }
        })
    }
}