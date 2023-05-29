package com.example.testproject.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.MainActivity
import com.example.testproject.backend.BackendAPI
import com.example.testproject.backend.LoginCredentials
import com.example.testproject.backend.LoginResponseApiModule
import com.example.testproject.backend.Repository
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {

    private val API_Interface = LoginResponseApiModule.provideRetrofit().create(BackendAPI::class.java)
    private val loginRepository = Repository(API_Interface)

    fun onLoginRequested(username:String, password:String, context: Context,onSuccessCallback:()-> Unit, onFailureCallback:()->Unit){
        viewModelScope.launch {
            val response = loginRepository.loginUser(LoginCredentials(username,password))
            when(response.isSuccessful){
                true -> {
                    if(!response.body()?.accessToken.isNullOrEmpty()){
                        response.body()?.accessToken?.let {
                            MainActivity.userPreferences.saveAccessToken(it)
                        }
                        onSuccessCallback()
                    }else{
                        onFailureCallback()
                    }
                }
                else -> {
                    onFailureCallback()
                }
            }
        }
    }
}