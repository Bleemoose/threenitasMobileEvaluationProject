package com.example.testproject.backend
import com.google.gson.annotations.SerializedName



const val API_URL = "https://3nt-demo-backend.azurewebsites.net/Access/"

data class LoginCredentials(
    @SerializedName("UserName")
    val userName:String,
    @SerializedName("Password")
    val password:String
)

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String? = null,
    @SerializedName("expires_in")
    val expiresIn: Int? = null,
    @SerializedName("refresh_token")
    val refreshToken: String? = null,
    @SerializedName("token_type")
    val tokenType: String? = null
)