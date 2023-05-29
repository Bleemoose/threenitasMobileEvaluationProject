@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.testproject.myComposables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import com.example.testproject.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


@Composable
fun MyTextField(isPassword: Boolean, textFieldLabel: String, textFieldHint: String , onValueChangedCallback: (String)->Unit) {

    val textFieldVariable = remember{ mutableStateOf("") }
    var visible = remember { mutableStateOf(false) }
    var showDialog = remember { mutableStateOf(false) }

    Column() {
        Row(
            modifier = Modifier.then(
                if (isPassword) Modifier.padding(start = 41.dp, top = 30.dp)
                else Modifier.padding(top = 71.dp, start = 41.dp)
            ),
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = textFieldLabel,
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Image(
                painterResource(R.drawable.ic_info),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .width(20.dp)
                    .clickable(onClick = { showDialog.value = !showDialog.value })
            )
            if (isPassword) {
                Text(
                    modifier = Modifier
                        .padding(start = 127.dp)
                        .clickable { visible.value = !visible.value },
                    text = if (!visible.value) stringResource(id = R.string.show_password)
                    else stringResource(
                        id = R.string.hide_password
                    ),
                    color = Color(0xff2c9f1d),
                    fontFamily = FontFamily.Monospace,
                    fontSize = 13.sp
                )
            }
        }

        OutlinedTextField(modifier = Modifier
            .padding(top = 10.dp, start = 38.dp, end = 38.dp)
            .fillMaxWidth(),
            value = textFieldVariable.value,
            placeholder = {
                Text(
                    text = textFieldHint,
                    style = TextStyle(
                        color = Color.White,
                        textAlign = TextAlign.Start,
                        fontSize = 16.sp
                    )
                )
            },
            visualTransformation = if (visible.value || !isPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.White,
                focusedIndicatorColor =  Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.Transparent,
                textColor = Color.White
            ),
            onValueChange = {
                textFieldVariable.value = it
                onValueChangedCallback(it)
            })

        Divider(
            color = Color(0xff50a235),
            thickness = 2.dp,
            modifier = Modifier
                .padding(start = 38.dp,end=38.dp)
        )
    }
    if (showDialog.value) {
        Dialog(
            onDismissRequest = {showDialog.value= !showDialog.value}
        )
        {
            InfoButtonDialog()
        }
    }
}