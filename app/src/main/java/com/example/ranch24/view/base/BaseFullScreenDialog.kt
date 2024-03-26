package com.example.ranch24.view.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.ranch24.R

open class BaseFullScreenDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.RanchFullScreenDialogStyle)
    }

    override fun onStart() {
        super.onStart()

        val dialog = dialog

        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT

            dialog.window?.setLayout(width, height)

            if (isDialogAnimated) dialog.window?.setWindowAnimations(R.style.RanchFullScreenDialogAnimationStyle)
        }
    }

    protected open val isDialogAnimated: Boolean = true
}