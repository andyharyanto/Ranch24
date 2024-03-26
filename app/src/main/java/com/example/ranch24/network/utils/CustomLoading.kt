package com.example.ranch24.network.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ranch24.R
import com.example.ranch24.view.base.BasePopUpDialog

class CustomLoading: BasePopUpDialog() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return requireActivity().layoutInflater
            .inflate(R.layout.layout_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isCancelable = false
    }

    override val isDialogAnimated: Boolean
        get() = false
}