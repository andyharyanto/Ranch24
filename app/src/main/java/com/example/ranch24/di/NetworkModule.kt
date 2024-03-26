package com.example.ranch24.di

import com.example.ranch24.network.utils.RanchClient
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModule = module {

    single(named(BASE_URL)) {RanchClient.baseUrl}
}

const val BASE_URL = "BASE_URL"