package com.example.challengekosmosirwin.data.datasource

import com.example.challengekosmosirwin.data.entity.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyDataSource {

    @GET("api/character")
    suspend fun getCharacters(page: String) : Response<RickAndMortyResponse>

}