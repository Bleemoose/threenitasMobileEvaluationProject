package com.example.testproject

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testproject.ViewModels.LoginViewModel
import com.example.testproject.myComposables.ErrorBubble
import com.example.testproject.myComposables.LanguagePickerDropdownMenu
import com.example.testproject.myComposables.LoginButton
import com.example.testproject.myComposables.MyTextField


@Composable
fun LoginPage(loginViewModel: LoginViewModel = viewModel(), onNavigateToMagazines: () -> Unit) {

    LoginPageContent(loginViewModel, LocalContext.current) {
        onNavigateToMagazines()
    }
}

@Composable
fun LoginPageContent(loginViewModel: LoginViewModel, context: Context, onLoginSuccess: () -> Unit) {
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var errorDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(Color(0xff101417))
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(74.dp)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        )
        {
            Text(
                text = stringResource(id = R.string.login_label),
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontSize = 28.sp
            )
        }
        MyTextField(
            isPassword = false,
            textFieldLabel = "UserID",
            textFieldHint = "123456",
            onValueChangedCallback = { username = it }
        )
        MyTextField(
            isPassword = true,
            textFieldLabel = "Password",
            textFieldHint = "Enter Password",
            onValueChangedCallback = { password = it }
        )
        if (errorDialog) {
            Dialog(
                onDismissRequest = { errorDialog = !errorDialog }
            )
            {
                ErrorBubble() {
                    errorDialog = !errorDialog
                }
            }
        }
        LanguagePickerDropdownMenu(
            modifier = Modifier.align(Alignment.End)
        )

        LoginButton() {
            loginViewModel.onLoginRequested(username, password, context,
                onSuccessCallback = {
                    onLoginSuccess()
                    Log.d("Login Successful", "Success")
                },
                onFailureCallback = {
                    errorDialog = true
                    Log.d("Login Failure", "Failure")
                })
        }
    }
}



