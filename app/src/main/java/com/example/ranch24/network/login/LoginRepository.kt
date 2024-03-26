package com.example.ranch24.network.login

import com.example.ranch24.model.login.LoginRequest
import com.example.ranch24.model.login.LoginResponse

class LoginRepository(private val loginService: LoginService) {
    suspend fun postLoginUser(body: LoginRequest): LoginResponse =
        loginService.postLogin(body)
}