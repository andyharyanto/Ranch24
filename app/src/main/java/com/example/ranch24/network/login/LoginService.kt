package com.example.ranch24.network.login

import com.example.ranch24.model.login.LoginRequest
import com.example.ranch24.model.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("login")
    suspend fun postLogin(
        @Body body: LoginRequest
    ): LoginResponse
}