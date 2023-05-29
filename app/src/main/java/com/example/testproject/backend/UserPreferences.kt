package com.example.testproject.backend

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {

    companion object{
        private const val ACCESS_TOKEN_FIELD = "user_access_token"
        private const val SHARED_PREFS_KEY = "com.example.threenitastraining.USER_DATA"
    }

    private var SharePreference : SharedPreferences = context.getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE)

    fun saveAccessToken(accessToken : String){
        with(SharePreference.edit()){
            putString(ACCESS_TOKEN_FIELD, accessToken)
            apply()
        }
    }

    fun getAccessToken() : String? {
        return SharePreference.getString(ACCESS_TOKEN_FIELD, null)
    }
}