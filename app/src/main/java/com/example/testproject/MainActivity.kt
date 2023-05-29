@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.testproject

import ScreenMain
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.testproject.backend.UserPreferences


//TODO: Languages / Cleanup / MagazinesPage / Font / Finish Magazine Page (Bottom Bar with Icons and actual content)


class MainActivity : ComponentActivity() {
    companion object {
        lateinit var userPreferences: UserPreferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userPreferences = UserPreferences(this)

        setContent{
            ScreenMain()
        }

    }
}



