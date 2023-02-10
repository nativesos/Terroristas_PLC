package com.jhonacode.terroristasplc.starting.ui.body

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jhonacode.terroristasplc.R
import com.jhonacode.terroristasplc.ui.widgets.CustomImage

@Composable
fun StartingBody(imageBody: Int, bottonText: String){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomImage(
            imageId = imageBody,
            width = 300,
            height = 300,
        )

        Box(modifier = Modifier.padding(start = 50.dp, end = 50.dp)
        ){
            Text(
                text = bottonText,
                fontSize = 20.sp
            )

        }

    }


}