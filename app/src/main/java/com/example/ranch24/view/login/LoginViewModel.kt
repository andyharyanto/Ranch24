package com.example.ranch24.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klepmobileproject.utils.SingleLiveEvent
import com.example.ranch24.model.login.LoginRequest
import com.example.ranch24.model.login.LoginResponse
import com.example.ranch24.network.login.LoginRepository
import com.example.ranch24.session.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(private val loginRepository: LoginRepository, private val sessionManager: SessionManager): ViewModel() {
    var loadingEvent = SingleLiveEvent<Boolean>()

    var goToMainActivity = SingleLiveEvent<Any>()
    var showErrorEvent = SingleLiveEvent<String>()

    fun buttonLoginClicked(email: String, password: String) {
        loadingEvent.value = true

        viewModelScope.launch {
            try {
                var response: LoginResponse? = null
                val req = LoginRequest()
                req.email = email
                req.password = password

                withContext(Dispatchers.IO) {
                    response = loginRepository.postLoginUser(
                        req
                    )
                }

                if(response?.accessToken != "") {
                    goToMainActivity.value = ""
                    sessionManager.isLogged = true
                    sessionManager.accountToken = response?.accessToken!!
                } else {
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