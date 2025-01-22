package com.example.viewmodeldemocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodeldemocompose.ui.theme.ViewModelDemoComposeTheme

@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {

    // way to initialize the view model
//    private val viewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ViewModelDemoComposeTheme {
                val viewModel = viewModel<MyViewModel>(
                // this way if you want to send data using the constructor
                    factory = object: ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return MyViewModel(
                                color = Color.Green
                            ) as T
                        }
                    }
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(viewModel.backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Button(onClick = {
                        viewModel.changeBackgroundColor()
                    }) {
                        Text(text = "Change color")
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
    ViewModelDemoComposeTheme {
        Greeting("Android")
    }
}