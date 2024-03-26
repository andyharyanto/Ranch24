package com.example.ranch24.view.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.ranch24.databinding.ActivityRegisterBinding
import com.example.ranch24.view.base.BaseActivity
import com.example.ranch24.view.home.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity: BaseActivity() {

    private val registerViewModel: RegisterViewModel by viewModel()

    private lateinit var binding: ActivityRegisterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initListener()
        initObserver()
    }

    private fun initListener() {
        binding.btnRegister.setOnClickListener {
            if(binding.etEmail.text.toString().isEmpty() || binding.etEmail.text.toString().isEmpty() ||
                binding.etConfirmationPassword.text.toString().isEmpty()) {
                Toast.makeText(this, "Email, Password, dan Konfirmasi Password harus diisi.", Toast.LENGTH_LONG).show()
            } else if (binding.etPassword.text.toString() != binding.etConfirmationPassword.text.toString()) {
                Toast.makeText(this, "Password dan Konfirmasi Password harus sama.", Toast.LENGTH_LONG).show()
            } else {
                registerViewModel.buttonRegisterClicked(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
            }
        }
    }

    private fun initObserver() {
        registerViewModel.goToHome.observe(this) {
            Toast.makeText(this, "Berhasil Register", Toast.LENGTH_LONG).show()
            val i = Intent(this, HomeActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
            finish()
        }
        registerViewModel.showErrorEvent.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        registerViewModel.loadingEvent.observe(this) {
            if (it) showLoading()
            else stopLoading()
        }
    }
}