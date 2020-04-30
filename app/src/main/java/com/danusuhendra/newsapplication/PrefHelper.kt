package com.danusuhendra.newsapplication

import android.content.Context

class PrefHelper(private val context: Context) {
    companion object {
        const val FIRST = "FIRST"
    }

    private val sharedPreferences = context.getSharedPreferences("news", Context.MODE_PRIVATE)

    var first : Boolean
        get() {
            return sharedPreferences.getBoolean(FIRST, false)
        }
        set(value) {
            sharedPreferences.edit().apply(){
                putBoolean(FIRST, value)
                apply()
            }
        }
}