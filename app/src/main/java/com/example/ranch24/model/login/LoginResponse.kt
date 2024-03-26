package com.example.ranch24.model.login

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("token")
    var accessToken: String? = ""

    @SerializedName("error")
    var error: String? = ""
}