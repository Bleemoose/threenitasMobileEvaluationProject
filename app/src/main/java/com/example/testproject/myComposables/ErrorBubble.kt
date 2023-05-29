package com.example.testproject.myComposables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import com.example.testproject.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorBubble(onBackPressedCallback:()->Unit) {

    val forestGreen = Color(0xff85c370)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 54.dp)
            .heightIn(124.dp),
        shape = RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier.padding(top = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = stringResource(id = R.string.wrong_credential_title),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 17.sp,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = stringResource(id = R.string.wrong_credential_description),
                color = Color.White,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace
            )
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 10.dp).fillMaxWidth()
            )
            OutlinedButton(
                shape = CutCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier.fillMaxWidth(),
                onClick = { onBackPressedCallback() })
            {
                Text(
                    text = stringResource(id = R.string.error_bubble_button_content),
                    color = forestGreen,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}