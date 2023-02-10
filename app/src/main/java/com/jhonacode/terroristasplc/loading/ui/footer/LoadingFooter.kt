package com.jhonacode.terroristasplc.starting.ui.footer

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LoadingFooter(){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding( bottom = 50.dp ),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp),
            strokeWidth = 1.dp,
            color = Color.Black,
        )
    }


}