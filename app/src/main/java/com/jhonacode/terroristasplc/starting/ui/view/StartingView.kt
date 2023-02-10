package com.jhonacode.terroristasplc.starting.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.jhonacode.terroristasplc.R
import com.jhonacode.terroristasplc.starting.ui.body.StartingBody
import com.jhonacode.terroristasplc.starting.ui.footer.StatingFooter
import com.jhonacode.terroristasplc.starting.ui.header.StartingHeader


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartingView() {

    val text1   = "Amplia base de datos verificada de terroristas buscados en todo el mundo. ¡Ayuda a mantener seguro el mundo!."
    val tittle1 = "Porque usar\nTerroristas PLC"
    val tittle2 = "Tus Datos"
    val text2   = "- Sin recopilar datos\n- Sin registro\n- Sin internet una vez sincronizado\n- Elige cuando actualizar"

    val page = rememberSaveable { mutableStateOf(1) }

    Scaffold(

        topBar = {
            StartingHeader(
                tittle = if(page.value == 1) tittle1 else tittle2
            ) },

        bottomBar = {
            Box( modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(bottom = 10.dp, top = 10.dp, end = 10.dp),
                Alignment.BottomEnd
            ) {
                StatingFooter(

                    tittle = if(page.value == 1) "Continuar ->" else "Importar ->",
                    onCLick = {
                        page.value = if (page.value == 1) 2 else 1

                    }

                )
            }
        }

    ) {
        StartingBody(
            imageBody  =  if(page.value == 1) R.drawable.search_terrorist else R.drawable.data_error,
            bottonText =  if(page.value == 1) text1 else text2
        )
    }


}