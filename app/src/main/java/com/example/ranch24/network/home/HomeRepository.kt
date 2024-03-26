package com.example.ranch24.network.home

import com.example.ranch24.model.home.HomeDataResponse

class HomeRepository(private val homeService: HomeService) {
    suspend fun getListData(): HomeDataResponse =
        homeService.getHomeData()
}

