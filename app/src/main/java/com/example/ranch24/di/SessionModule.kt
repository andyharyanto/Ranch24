package com.example.ranch24.di

import com.example.ranch24.session.SessionManager
import org.koin.dsl.module

val sessionModule = module {
    single { SessionManager(get()) }
}