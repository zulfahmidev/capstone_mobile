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

    @Headers("Content-Type: application/json")
    @GET("major")
    fun major(@Body body: MajorData): Call<MajorResponse>

    @GET("auth/me")
    fun account(@Header("Authorization") token: String): Call<AccountResponse>
}