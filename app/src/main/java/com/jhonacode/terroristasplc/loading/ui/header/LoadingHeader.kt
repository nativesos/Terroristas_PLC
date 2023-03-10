package com.jhonacode.terroristasplc.starting.ui.header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jhonacode.terroristasplc.ui.widgets.CustomTitle


@Composable
fun LoadingHeader(){

    Box(
        Modifier
            .fillMaxWidth()
            .padding(top = 50.dp)
    ){
        CustomTitle(tittle = "Terroristas\nPLC", fontSize = 50)
    }


}