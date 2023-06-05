package com.capstone.arahku.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.arahku.api.ApiConfig
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.response.MajorBody
import com.capstone.arahku.model.response.MajorData
import com.capstone.arahku.model.response.MajorResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MajorViewModel(private val preference: UserPreference): ViewModel() {

    private val _listMajor = MutableLiveData<MajorData?>()
    val listMajor: LiveData<MajorData?> = _listMajor

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    fun getMajor(majorBody: MajorBody) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().major(majorBody)
        client.enqueue(object : Callback<MajorResponse> {
            override fun onResponse(call: Call<MajorResponse>, response: Response<MajorResponse>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _listMajor.value = response.body()?.data
                    }
                }else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MajorResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
                _status.value = "Data failed to load, please try again."
            }
        })
    }

    companion object {
        private const val TAG = "MajorViewModel"
    }
}