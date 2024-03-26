package com.example.ranch24.network.home

import com.example.ranch24.model.home.HomeDataResponse
import retrofit2.http.GET

interface HomeService {
    @GET("unknown")
    suspend fun getHomeData(): HomeDataResponse
}