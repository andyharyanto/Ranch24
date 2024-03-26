package com.example.ranch24.model.home

import com.google.gson.annotations.SerializedName

class HomeDataResponse {
    @SerializedName("data")
    val listData: ArrayList<HomeData> = arrayListOf()
}

class HomeData {
    @SerializedName("id")
    val id: Int = 0

    @SerializedName("name")
    val name: String = ""

    @SerializedName("year")
    val year: Int = 0

    @SerializedName("color")
    val color: String = ""

    @SerializedName("pantone_value")
    val pantoneValue: String = ""
}