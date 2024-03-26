package com.example.ranch24.di

import com.example.ranch24.network.home.HomeRepository
import com.example.ranch24.network.home.HomeService
import com.example.ranch24.view.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule = module {
    factory { HomeRepository(get<Retrofit>(named(BASE_URL)).create(HomeService::class.java)) }

    viewModel { HomeViewModel(get(), get()) }
}