package com.jhonacode.terroristasplc.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jhonacode.terroristasplc.home.ui.header.HomeHeader
import com.jhonacode.terroristasplc.home.ui.widget.TerroristCardInfo

@Preview
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeView(){
    Scaffold(
        topBar = {HomeHeader()}
    ) {

        Column(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .verticalScroll(rememberScrollState())
                .padding(top = 10.dp)
        ) {
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
            TerroristCardInfo()
        }

    }
}