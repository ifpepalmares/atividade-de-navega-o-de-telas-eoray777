package com.example.firstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "screen_a") {

                    composable("screen_a") {
                        ScreenA(navController)
                    }

                    composable("screen_b") {
                        ScreenB(navController, "clica nn")
                    }
            }
        }
    }
}

@Composable
fun ScreenA(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).background(color = Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Não clique no botão", color = Color.Cyan)
        Button(onClick = { navController.navigate("screen_b") }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        )) {
            Text("Botão")
        }
    }
}

@Composable
fun ScreenB(navController: NavController, message: String?) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).background(color = Color.Red),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Não clica no botão dnv", color = Color.Cyan)
        message?.let { Text(text = "Namoral, $it", color = Color.Cyan) }
        Button(onClick = { navController.popBackStack() }, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
                )) {
            Text("botão")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAPreview() {
    ScreenA(rememberNavController())
    }


@Preview(showBackground = true)
@Composable
fun ScreenBPreview() {

        ScreenB(rememberNavController(), "Olá da Tela A")
    }
