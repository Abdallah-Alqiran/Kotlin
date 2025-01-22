package com.example.viewmodeldemocompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel


class MyViewModel(private val color: Color) : ViewModel() {
    var backgroundColor by mutableStateOf(color)

    fun changeBackgroundColor() {
        backgroundColor = if (backgroundColor == color) {
            Color.Red
        } else {
            color
        }
    }

}