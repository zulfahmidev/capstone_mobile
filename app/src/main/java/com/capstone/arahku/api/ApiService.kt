package com.capstone.arahku.api

import com.capstone.arahku.model.LoginBody
import com.capstone.arahku.model.LoginResponse
import com.capstone.arahku.model.RegisterBody
import com.capstone.arahku.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("auth/register")
    fun register(@Body body: RegisterBody): Call<RegisterResponse>

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun login(@Body body: LoginBody): Call<LoginResponse>
}