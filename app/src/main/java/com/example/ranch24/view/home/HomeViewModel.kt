package com.example.ranch24.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klepmobileproject.utils.SingleLiveEvent
import com.example.ranch24.model.home.HomeData
import com.example.ranch24.model.home.HomeDataResponse
import com.example.ranch24.network.home.HomeRepository
import com.example.ranch24.session.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val homeRepository: HomeRepository, private val sessionManager: SessionManager): ViewModel(){

    var loadingEvent = SingleLiveEvent<Boolean>()
    var showErrorEvent = SingleLiveEvent<String>()
    var showListData = SingleLiveEvent<ArrayList<HomeData>>()
    var logoutEvent = SingleLiveEvent<Any>()

    fun getDataHome() {
        loadingEvent.value = true

        viewModelScope.launch {
            try {
                var response: HomeDataResponse?

                withContext(Dispatchers.IO) {
                    response = homeRepository.getListData()
                }

                if(response?.listData?.isNotEmpty() == true) {
                    showListData.value = response?.listData
                } else {
                    showErrorEvent.value = "List tidak ditemukan"
                }
            } catch (e: Exception) {
                showErrorEvent.value = e.message
                e.printStackTrace()
            } finally {
                loadingEvent.value = false
            }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            try {
                sessionManager.resetSession()
                logoutEvent.value = ""
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}