package com.example.ranch24.di

import com.example.ranch24.network.login.LoginRepository
import com.example.ranch24.network.login.LoginService
import com.example.ranch24.view.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val loginModule = module {
    factory { LoginRepository(get<Retrofit>(named(BASE_URL)).create(LoginService::class.java)) }

    viewModel { LoginViewModel(get(), get()) }
}