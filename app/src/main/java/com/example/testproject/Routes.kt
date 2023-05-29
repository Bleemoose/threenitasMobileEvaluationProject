package com.example.testproject

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Magazines : Routes("Magazines")
}