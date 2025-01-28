package com.example.retrofitcompose.retrofit

import retrofit2.http.GET


interface AlbumAPI {

    @GET("albums")
    suspend fun getAlbums(): List<Album>

}

