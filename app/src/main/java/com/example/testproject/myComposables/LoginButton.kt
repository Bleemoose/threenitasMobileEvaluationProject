package com.example.testproject.myComposables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import com.example.testproject.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(onClickCallback:()->Unit){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 124.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = {onClickCallback()},
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            border = BorderStroke(2.dp, Color(0xff85c370)),
            shape = RoundedCornerShape(35),
            colors = ButtonDefaults.buttonColors( containerColor = Color(0xff101417))
        ) {
            Text(
                text = stringResource(id = R.string.login_label),
                color = Color(0xff85c370),
                fontWeight = FontWeight.Bold
            )
        }
    }
}