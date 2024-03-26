package com.example.ranch24.view.splashScreen

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ranch24.databinding.ActivitySplashScreenBinding
import com.example.ranch24.session.SessionManager
import com.example.ranch24.view.home.HomeActivity
import com.example.ranch24.view.login.LoginActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.gifSplashScreen.playAnimation()
        binding.gifSplashScreen.speed = 1.8f

        binding.gifSplashScreen.addAnimatorListener(object : Animator.AnimatorListener {

            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                onCheckSliderFirstTime()
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }
        })
    }

    private fun onCheckSliderFirstTime() {

        val i: Intent =
            if (SessionManager(this).isLogged) {
                Intent(this, HomeActivity::class.java)
            } else {
                Intent(this, LoginActivity::class.java)
            }

        startActivity(i)
        finish()
    }
}