package com.jhonacode.terroristasplc.loading.ui.view

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jhonacode.terroristasplc.loading.ui.body.LoadingBody
import com.jhonacode.terroristasplc.starting.ui.footer.LoadingFooter
import com.jhonacode.terroristasplc.starting.ui.header.LoadingHeader


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview()
@Composable()
fun LoadingView(){
    Scaffold(
        backgroundColor = Color(0xFFFFFFFF),
        topBar = {LoadingHeader()},

        bottomBar = {LoadingFooter()}

    ) {
        LoadingBody()
    }
}