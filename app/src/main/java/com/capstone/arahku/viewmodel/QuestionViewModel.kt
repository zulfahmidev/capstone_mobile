package com.capstone.arahku.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.capstone.arahku.api.ApiConfig
import com.capstone.arahku.model.response.FieldsItemForm
import com.capstone.arahku.model.response.FormResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionViewModel: ViewModel() {

    private val _question = MutableLiveData<List<FieldsItemForm>?>()
    val question: LiveData<List<FieldsItemForm>?> = _question

    fun getForm(){
        val client = ApiConfig.getApiService().getForm()
        client.enqueue(object : Callback<FormResponse> {
            override fun onResponse(call: Call<FormResponse>, response: Response<FormResponse>) {
                if (response.isSuccessful){
                    _question.value = response.body()?.data?.fields as List<FieldsItemForm>?
                }

            }

            override fun onFailure(call: Call<FormResponse>, t: Throwable) {

            }
        })
    }

}