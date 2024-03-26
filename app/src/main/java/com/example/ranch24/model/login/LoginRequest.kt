package com.example.ranch24.model.login

import com.google.gson.annotations.SerializedName

class LoginRequest {
    @SerializedName("email")
    var email: String = ""

    @SerializedName("password")
    var password: String = ""
}