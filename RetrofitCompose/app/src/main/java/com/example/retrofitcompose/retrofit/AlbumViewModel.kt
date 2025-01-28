package com.example.retrofitcompose.retrofit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AlbumViewModel: ViewModel() {
    var _albumsList: MutableStateFlow<List<Album>> = MutableStateFlow<List<Album>>(emptyList())
    val albumList: StateFlow<List<Album>> = _albumsList

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {
        viewModelScope.launch {
            try {
                val albums = RetrofitInstance.api.getAlbums()
                _albumsList.value = albums
            } catch (e: Exception) {
                Log.e("REPOO", "Failed to fetch repositories: ${e.message}")
            }
        }
    }
}