package com.example.bankingapp

import android.R
import android.content.Context
import android.content.SharedPreferences


class InstalledBefore(context: Context) {
    var context: Context
    var sharedPreferences: SharedPreferences? = null
    val sPrefencesForInstalled: Unit
        get() {
            val sharedPreferences: SharedPreferences =
                context.getSharedPreferences("PREF_FILE", Context.MODE_PRIVATE)
            sharedPreferences.edit()
        }

    fun writeInstalled() {
        val editor = sharedPreferences!!.edit()
        editor.putString("ALREADY_INSTALLED", "YES")
        editor.apply()
    }
    fun checkingInstalled(): Boolean {
        var status = false
        status = sharedPreferences!!.getString(
            "PREF_FILE",
            "null"
        ) != "null"
        return status
    }
    fun eraseInstalled() {
        val editor = sharedPreferences!!.edit()
        editor.clear()
        editor.commit()
    }

    init {
        this.context = context
        sPrefencesForInstalled
    }
}