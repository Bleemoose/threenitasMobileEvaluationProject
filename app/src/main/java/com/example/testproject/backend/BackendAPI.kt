package com.example.testproject.backend
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface BackendAPI {
    @POST("Login")
    suspend fun login(@Body loginCredentials: LoginCredentials): Response<LoginResponse>

    @GET("Books")
    suspend fun getMagazines(@Header("Authorization") accessToken:String) : Response<List<Magazine>>
}



