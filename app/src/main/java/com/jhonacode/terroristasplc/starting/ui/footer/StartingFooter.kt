package com.jhonacode.terroristasplc.starting.ui.footer

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatingFooter(tittle: String, onCLick: ()-> Unit){

    Text(

        text = tittle,
        fontSize = 20.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.clickable( onClick = onCLick ),
    )

}