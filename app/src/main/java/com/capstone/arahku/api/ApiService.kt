package com.capstone.arahku.api

import com.capstone.arahku.model.*
import com.capstone.arahku.model.response.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("auth/register")
    fun register(@Body body: RegisterBody): Call<RegisterResponse>

    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun login(@Body body: LoginBody): Call<LoginResponse>

    @GET("auth/me")
    fun account(@Header("Authorization") token: String): Call<AccountResponse>

    @Headers("Content-Type: application/json")
    @POST("form/response")
    fun sendResponse(@Body body: SendResponse): Call<ReceiveResponse>

    @GET("form/minat-bakat")
    fun getForm(): Call<FormResponse>
}