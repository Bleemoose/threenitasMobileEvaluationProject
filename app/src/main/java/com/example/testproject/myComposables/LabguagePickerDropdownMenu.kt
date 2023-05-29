package com.example.testproject.myComposables

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import com.example.testproject.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import java.util.Locale


enum class LanguageType(val resource: Int, val language:String , val languageCode:String) {

    GREEK(R.drawable.greece_flag_round_icon,"Greek","el"),

    ENGLISH(R.drawable.united_states_of_america_flag_round,"English","en")

}


@Composable
fun LanguagePickerDropdownMenu(modifier: Modifier) {

    val isLanguagePickerOn = remember { mutableStateOf(false) }
    val selectedLanguageImage = remember { mutableStateOf(R.drawable.united_states_of_america_flag_round) }
    val selectedLanguageText = remember { mutableStateOf("English") }
    val context = LocalContext.current

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(top = 96.dp, end = 36.dp)
            .clip(RoundedCornerShape(35.dp))
            .background(Color.Black)
            .padding(10.dp)
            .widthIn(150.dp)
            .clickable { isLanguagePickerOn.value = isLanguagePickerOn.value == false })
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .width(32.dp)
                    .height(32.dp),
                painter = painterResource(id = selectedLanguageImage.value),
                contentDescription = null
            )
            Text(
                text = selectedLanguageText.value, color = Color.White, fontFamily = FontFamily.Monospace
            )
        }
        Image(
            painter = painterResource(id = R.drawable.arrow_down),
            contentDescription = null
        )
    }

    if (isLanguagePickerOn.value) {
        Column(
            modifier = modifier
                .padding(top = 6.dp, end = 36.dp)
                .clip(RoundedCornerShape(35.dp))
                .background(Color.Black)
        )
        {

            LanguagePickerChoices(LanguageType.GREEK) {
                if (selectedLanguageText.value != (LanguageType.GREEK.language)) {
                    switchLocale(LanguageType.GREEK.languageCode, context)
                    selectedLanguageImage.value = R.drawable.greece_flag_round_icon
                    selectedLanguageText.value = "Greek"
                }
            }
            LanguagePickerChoices(LanguageType.ENGLISH){
                if (selectedLanguageText.value != (LanguageType.ENGLISH.language)) {
                    switchLocale(LanguageType.ENGLISH.languageCode, context)
                    selectedLanguageImage.value = R.drawable.united_states_of_america_flag_round
                    selectedLanguageText.value = "English"
                }
            }
        }

    }
}

@Composable
private fun LanguagePickerChoices(languageType: LanguageType, onLanguageClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(10.dp)
            .widthIn(150.dp)
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = onLanguageClick)
        ) {
            Image(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .width(32.dp)
                    .height(32.dp),
                painter = painterResource(id = languageType.resource),
                contentDescription = null
            )
            Text(
                text = languageType.language, color = Color.White, fontFamily = FontFamily.Monospace
            )
        }
    }
}

private fun switchLocale(language: String, context: Context) {
    //Handle language change here
}