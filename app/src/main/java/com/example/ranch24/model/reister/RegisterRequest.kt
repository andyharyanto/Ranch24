package com.example.ranch24.model.reister

import com.google.gson.annotations.SerializedName

class RegisterRequest {
    @SerializedName("email")
    var email: String = ""

    @SerializedName("password")
    var password: String = ""
}