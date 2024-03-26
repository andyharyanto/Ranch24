package com.example.ranch24.view.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.ranch24.R
import com.example.ranch24.network.utils.CustomLoading

abstract class BaseActivity: AppCompatActivity() {
    lateinit var handler: Handler

    private var customLoadingPrimary: CustomLoading? = null

    @Deprecated("Deprecated in Java",
        ReplaceWith("super.onBackPressed()", "androidx.appcompat.app.AppCompatActivity")
    )
    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_base)
        handler = Handler(this.mainLooper)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LOCKED
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }

    fun showLoading() {
        if (customLoadingPrimary?.isAdded == true) {
            return
        } else {
            customLoadingPrimary = CustomLoading()
            customLoadingPrimary!!.show(supportFragmentManager, "Loading")
        }
    }

    fun stopLoading() {
        if (customLoadingPrimary != null) customLoadingPrimary!!.dismiss()
    }
}