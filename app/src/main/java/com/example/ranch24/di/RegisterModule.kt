package com.example.ranch24.di

import com.example.ranch24.network.register.RegisterRepository
import com.example.ranch24.network.register.RegisterService
import com.example.ranch24.view.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val registerModule = module {
    factory { RegisterRepository(get<Retrofit>(named(BASE_URL)).create(RegisterService::class.java)) }

    viewModel { RegisterViewModel(get(), get()) }
}