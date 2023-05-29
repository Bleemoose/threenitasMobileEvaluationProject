package com.example.testproject.myComposables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testproject.R

@Composable
fun InfoButtonDialog() {

    Surface(
        modifier = Modifier
            .padding(start = 38.dp, end = 38.dp)
            .heightIn(75.dp),
        shape = RoundedCornerShape(12.dp),
        color = Color.Black
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = R.string.info_button_text),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}