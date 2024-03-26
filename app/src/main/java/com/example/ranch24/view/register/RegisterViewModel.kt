package com.example.ranch24.view.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klepmobileproject.utils.SingleLiveEvent
import com.example.ranch24.model.reister.RegisterRequest
import com.example.ranch24.model.reister.RegisterResponse
import com.example.ranch24.network.register.RegisterRepository
import com.example.ranch24.session.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(private val registerRepository: RegisterRepository, private val sessionManager: SessionManager): ViewModel() {
    var loadingEvent = SingleLiveEvent<Boolean>()

    var goToHome = SingleLiveEvent<Any>()
    var showErrorEvent = SingleLiveEvent<String>()

    fun buttonRegisterClicked(email: String, password: String) {
        loadingEvent.value = true

        viewModelScope.launch {
            try {
                var response: RegisterResponse?
                val req = RegisterRequest()
                req.email = email
                req.password = password

                withContext(Dispatchers.IO) {
                    response = (
                        registerRepository.postRegisterUser(req)
                    )
                }

                if(response?.accessToken != "") {
                    goToHome.value = ""
                    sessionManager.isLogged = true
                    sessionManager.accountToken = response?.accessToken!!
                } else {
                    Log.d("Error nih", response?.error ?: "")
                    showErrorEvent.value = response?.error ?: ""
                }
            } catch (e: Exception) {
                showErrorEvent.value = e.message
                e.printStackTrace()
            } finally {
                loadingEvent.value = false
            }
        }
    }
}