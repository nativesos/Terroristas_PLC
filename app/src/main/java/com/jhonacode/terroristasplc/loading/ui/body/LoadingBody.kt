package com.jhonacode.terroristasplc.loading.ui.body


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jhonacode.terroristasplc.R
import com.jhonacode.terroristasplc.ui.widgets.CustomImage


@Composable
internal fun LoadingBody(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomImage(
            imageId = R.drawable.criminal_info,
            height = 300,
            width = 300,
        )

    }
}