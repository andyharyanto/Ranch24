package com.example.ranch24

import android.annotation.SuppressLint
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.example.ranch24.di.*
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity: MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)
        context = applicationContext

        startKoin {
            androidContext(this@MainActivity)

            modules(
                networkModule,
                loginModule,
                registerModule,
                sessionModule,
                homeModule
            )
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context
    }
}