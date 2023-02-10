package com.jhonacode.terroristasplc


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat.animate
import com.jhonacode.terroristasplc.api.repository.ApiRepository
import com.jhonacode.terroristasplc.api.service.ApiService
import com.jhonacode.terroristasplc.loading.ui.view.LoadingView
import com.jhonacode.terroristasplc.starting.ui.view.StartingView
import com.jhonacode.terroristasplc.ui.theme.TerroristasPLCTheme

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerroristasPLCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview(this)
                }
            }
        }
    }
}

@Composable
fun DefaultPreview(context: MainActivity) {
    TerroristasPLCTheme {
        Surface {
            LoadingScreen(context = context)
        }

    }
}





/// Loading Screen
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoadingScreen(context: MainActivity){

    val apiService: ApiService = ApiService(context)
    val apiRepository: ApiRepository = ApiRepository(context);

    /// Esta validacion es solo por test, se debe hacer una inyeccion de dependencias para usar.
    /// las vistas dependiendo de las siguiente variables
    if ( apiService.isDataPresent ){

        /// Primero comprueba si tiene datos, si no tiene debe salir el textoq ue explica de que va la app
        /// Luego Salir los requisitos y al darle siguiente debe salir el loading que esta cargando los datos.
        /// Luego de eso salen los datos en una pantalla
        /// Luego debe poder buscar por nombre o apellido

        LoadingView() /// Solo poner cuando cargan los datos antes de home page


        /// Formato generado en el terrorista.json
        /**


        {
        "sdnType": "Individual",
        "uid": "9639",
        "firstName": "Ismail Abdul Salah",
        "lastName": "HANIYA",
        "programList": "NS-PLC"
        }

         */

    }else {
        StartingView()
//        Button(
//
//            onClick = {
//
//                GlobalScope.launch(Dispatchers.IO) {
//                    try {
//
//
//                        apiService.importData(apiRepository.httpConnection())
//
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                    }
//
//                }
//
//
//            }) {
//
//            Text(text = "Load Data")
//        }
    }

}