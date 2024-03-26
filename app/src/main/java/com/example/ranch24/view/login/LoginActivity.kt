package com.example.ranch24.view.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.ranch24.databinding.ActivityLoginBinding
import com.example.ranch24.view.base.BaseActivity
import com.example.ranch24.view.home.HomeActivity
import com.example.ranch24.view.register.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity: BaseActivity() {
    private val loginViewModel: LoginViewModel by viewModel()

    private lateinit var binding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initListener()
        initObserver()
    }

    private fun initListener() {
        binding.btnLogin.setOnClickListener {
            if(binding.etEmail.text.toString().isEmpty() || binding.etEmail.text.toString().isEmpty()) {
                Toast.makeText(this, "Email dan Password harus diisi.", Toast.LENGTH_LONG).show()
            } else {
                loginViewModel.buttonLoginClicked(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
            }
        }
        binding.btnRegister.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }

    private fun initObserver() {
        loginViewModel.goToMainActivity.observe(this) {
            Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show()
            Log.d("Ha", "Masuk gotomain")
            val i = Intent(this, HomeActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            finish()
        }
        loginViewModel.showErrorEvent.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            Log.d("Ha", "Masuk error")
        })
        loginViewModel.loadingEvent.observe(this, Observer {
            if (it) showLoading()
            else stopLoading()
        })
    }
}