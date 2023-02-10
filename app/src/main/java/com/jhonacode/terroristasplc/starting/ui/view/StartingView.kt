package com.jhonacode.terroristasplc.starting.ui.view

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.jhonacode.terroristasplc.starting.ui.header.StartingHeader


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartingView(){

    Scaffold(
        topBar = {StartingHeader()}
    ) {

    }


}