package com.example.testproject.ViewModels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.MainActivity
import com.example.testproject.backend.BackendAPI
import com.example.testproject.backend.LoginResponseApiModule
import com.example.testproject.backend.Magazine
import com.example.testproject.backend.Repository
import kotlinx.coroutines.launch

class MagazineViewModel : ViewModel() {

    private val API_Interface = LoginResponseApiModule.provideRetrofit().create(BackendAPI::class.java)
    private val repository = Repository(API_Interface)


    val magazineList:MutableState<List<Magazine>> =  mutableStateOf(emptyList<Magazine>())


    fun getMagazines(){
        viewModelScope.launch {

            val accessToken = MainActivity.userPreferences.getAccessToken()

            if(!accessToken.isNullOrEmpty()){
                val response = repository.getBooks("Bearer $accessToken")
                magazineList.value = response.body()!!

            }else{
                Log.e("NO TOKEN", "NO ACCESS TOKEN IN MAGAZINE PAGE")
            }
        }
    }
}