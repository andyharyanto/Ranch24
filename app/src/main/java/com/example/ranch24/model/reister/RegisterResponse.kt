package com.example.ranch24.model.reister

import com.google.gson.annotations.SerializedName

class RegisterResponse {
    @SerializedName("id")
    var id: Int? = 0

    @SerializedName("token")
    var accessToken: String? = ""

    @SerializedName("error")
    var error: String? = ""
}