package com.example.foregroundservicecompse

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.foregroundservicecompse.ui.theme.ForegroundServiceCompseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ForegroundServiceCompseTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        Intent(this@MainActivity, ForegroundService::class.java).also {
                            it.action = ForegroundService.Actions.START.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "Start Service")
                    }
                    
                    Button(onClick = { 
                        Intent(this@MainActivity, ForegroundService::class.java).also {
                            it.action = ForegroundService.Actions.STOP.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "Stop Service")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ForegroundServiceCompseTheme {
        Greeting("Android")
    }
}