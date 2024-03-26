package com.example.ranch24.network.register

import com.example.ranch24.model.reister.RegisterRequest
import com.example.ranch24.model.reister.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("register")
    suspend fun postRegister(
        @Body body: RegisterRequest
    ): RegisterResponse
}