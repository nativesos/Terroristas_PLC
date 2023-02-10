package com.jhonacode.terroristasplc


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jhonacode.terroristasplc.api.repository.ApiRepository
import com.jhonacode.terroristasplc.ui.theme.TerroristasPLCTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.NodeList
import org.xml.sax.helpers.DefaultHandler
import java.io.File
import java.io.FileWriter
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.SAXParserFactory

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
        LoadingScreen(context)

    }
}

/// Loading Screen
@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoadingScreen(context: MainActivity){

   // MyScreen()
   // LoadingView()
    Button(

        onClick = {

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val url = URL("https://www.treasury.gov/ofac/downloads/consolidated/consolidated.xml")

                    val connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"
                    connection.connect()
                    ApiRepository.convert6(connection, context)

                } catch (e: Exception) {
                    e.printStackTrace()
                }
                println("Operación de red finalizadaiiiiii")
            }



    }) {
        Text(text = "Load Data")
    }


}