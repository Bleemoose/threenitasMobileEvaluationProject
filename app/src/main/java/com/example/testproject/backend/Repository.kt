package com.example.testproject.backend

import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val API: BackendAPI
) {

    suspend fun loginUser(loginCredentials: LoginCredentials): Response<LoginResponse> {
        return API.login(loginCredentials)
    }

    suspend fun getBooks(accessToken: String): Response<List<Magazine>> {
        return API.getMagazines(accessToken)
    }
}