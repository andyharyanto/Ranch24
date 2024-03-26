package com.example.ranch24.view.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.ranch24.databinding.ActivityHomeBinding
import com.example.ranch24.view.base.BaseActivity
import com.example.ranch24.view.home.adapter.HomeListAdapter
import com.example.ranch24.view.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity: BaseActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        homeViewModel.getDataHome()

        initListener()
        initObserver()
    }

    private fun initListener() {
        binding.btnLogout.setOnClickListener {
            homeViewModel.logOut()
        }
    }

    private fun initObserver() {
        homeViewModel.showListData.observe(this) {
            if(it.isNotEmpty()) {
                getCartListAdapter().setData(it)
            } else {
                getCartListAdapter().clearData()
            }
        }
        homeViewModel.showErrorEvent.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        homeViewModel.loadingEvent.observe(this) {
            if (it) showLoading()
            else stopLoading()
        }

        homeViewModel.logoutEvent.observe(this) {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getCartListAdapter(): HomeListAdapter {
        val adapter: HomeListAdapter

        if (binding.rvProductList.adapter != null) {
            adapter = binding.rvProductList.adapter as HomeListAdapter
        } else {
            adapter = HomeListAdapter()
            binding.rvProductList.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        return adapter
    }
}