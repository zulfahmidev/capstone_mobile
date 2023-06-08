package com.capstone.arahku.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.capstone.arahku.api.ApiConfig
import com.capstone.arahku.model.UserPreference
import com.capstone.arahku.model.response.FieldsItemForm
import com.capstone.arahku.model.response.FormResponse
import com.capstone.arahku.model.response.ReceiveResponse
import com.capstone.arahku.model.response.SendResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionViewModel(private val preference: UserPreference): ViewModel() {

    private val _question = MutableLiveData<List<FieldsItemForm>?>()
    val question: LiveData<List<FieldsItemForm>?> = _question

    private val _formId = MutableLiveData<Int>()
    val formId : LiveData<Int> = _formId

    private val _questionStatus = MutableLiveData<Boolean>()
    val questionStatus: LiveData<Boolean> = _questionStatus

    private val _responseStatus = MutableLiveData<Boolean>()
    val responseStatus: LiveData<Boolean> = _responseStatus

    private val _receivedResponse = MutableLiveData<ReceiveResponse>()
    val receivedResponse : LiveData<ReceiveResponse> = _receivedResponse

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getId(): LiveData<Int> {
        return preference.getId().asLiveData()
    }
    fun getForm(){
        _isLoading.value = true
        val client = ApiConfig.getApiService().getForm()
        client.enqueue(object : Callback<FormResponse> {
            override fun onResponse(call: Call<FormResponse>, response: Response<FormResponse>) {
                _isLoading.value = false
                if (response.isSuccessful){
                    val responseBody = response.body()
                    _question.value = responseBody?.data?.fields as List<FieldsItemForm>?
                    _formId.value = responseBody?.data?.id as Int

                }

            }

            override fun onFailure(call: Call<FormResponse>, t: Throwable) {
                _isLoading.value = false
            }
        })
    }

    fun sendResponse(body: SendResponse){
        _isLoading.value = true
        val client = ApiConfig.getApiService().sendResponse(body)
        client.enqueue(object : Callback<ReceiveResponse>{
            override fun onResponse(
                call: Call<ReceiveResponse>,
                response: Response<ReceiveResponse>
            ) {
                _isLoading.value = false
               if (response.isSuccessful){
                   _responseStatus.value = true
                   _receivedResponse.value = response.body()

               }else{
                   _responseStatus.value = false
                   Log.e("Test", "onFailure: ${response.message()}")
               }
            }

            override fun onFailure(call: Call<ReceiveResponse>, t: Throwable) {
                _isLoading.value = false
                _responseStatus.value = false
                Log.e("Test", "onFailure: ${t.message}")
            }
        })
    }

    init {
        getForm()
    }

}