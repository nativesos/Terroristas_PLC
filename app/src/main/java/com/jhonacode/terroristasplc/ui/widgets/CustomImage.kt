package com.jhonacode.terroristasplc.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomImage(imageId: Int){
    Image(
        modifier = Modifier
            .height(300.dp)
            .width(300.dp)
            .padding(top = 50.dp)
        ,
        painter = painterResource(id = imageId ),
        contentDescription = "settings"
    )
}