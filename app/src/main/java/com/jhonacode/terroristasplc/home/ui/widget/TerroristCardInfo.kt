package com.jhonacode.terroristasplc.home.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jhonacode.terroristasplc.R
import com.jhonacode.terroristasplc.ui.widgets.CustomImage


@Preview
@Composable
fun TerroristCardInfo(){

    Box(modifier = Modifier
        .padding(all = 10.dp)
        .clip(shape = RoundedCornerShape(20.dp))
        .fillMaxWidth()
        .height(100.dp)
        .background(color = Color.LightGray)) {

        Row(modifier = Modifier
            .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier.padding(start = 10.dp, top = 10.dp)) {
                Image(painter = painterResource(id = R.drawable.criminal_company), contentDescription ="starticon",
                    modifier = Modifier
                        .width(width = 70.dp)
                        .height(height = 100.dp)
                )
            }
            Column(
                modifier = Modifier.padding(top = 10.dp, start = 5.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "NAME")
                Text(fontSize = 10.sp,text = " SURNAME STATE CORPORATION BANK FOR DEVELOPMENT AND FOREIGN ECONOMIC AFFAIRS VNESHECONOMBANK", overflow = TextOverflow.Clip)
                Text(text = "PROGRAM")
                Text(text = "ID")

            }

        }

    }

}