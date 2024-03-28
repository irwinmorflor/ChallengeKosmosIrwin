package com.example.challengekosmosirwin.data.api

import com.example.challengekosmosirwin.data.entity.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/character")
    suspend fun getCharacters(
        @Query("page") page: String
    ) : Response<RickAndMortyResponse>
}