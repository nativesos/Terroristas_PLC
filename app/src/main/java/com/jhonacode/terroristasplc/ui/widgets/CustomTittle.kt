package com.jhonacode.terroristasplc.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun CustomTitle(tittle: String, fontSize: Int){
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = tittle,
        fontSize = fontSize.sp,
        fontFamily = FontFamily.SansSerif
    )
}