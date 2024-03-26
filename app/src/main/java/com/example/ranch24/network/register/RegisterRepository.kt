package com.example.ranch24.network.register

import com.example.ranch24.model.reister.RegisterRequest
import com.example.ranch24.model.reister.RegisterResponse

class RegisterRepository(private val registerService: RegisterService) {
    suspend fun postRegisterUser(body: RegisterRequest): RegisterResponse =
        registerService.postRegister(body)
}