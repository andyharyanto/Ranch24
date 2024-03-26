package com.example.ranch24.session

import android.content.Context
import android.content.SharedPreferences
import com.example.ranch24.helper.HelperConstant

class SessionManager(context: Context) {
    val pref: SharedPreferences

    init {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun resetSession() {
        pref.edit().clear().apply()
    }

    var accountToken: String
        get() = pref.getString(HelperConstant.token, "").toString()
        set(accountToken) {
            pref.edit().putString(HelperConstant.token, accountToken).apply()
        }

    var isLogged: Boolean
        get() = pref.getBoolean(HelperConstant.is_logged, false)
        set(logged) {
            pref.edit().putBoolean(HelperConstant.is_logged, logged).apply()
        }

    companion object {
        private const val PREF_NAME = "SessionManagerRanch"
    }
}