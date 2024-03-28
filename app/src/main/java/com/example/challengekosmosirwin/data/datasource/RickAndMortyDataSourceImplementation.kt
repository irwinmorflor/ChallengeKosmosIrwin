package com.example.challengekosmosirwin.data.datasource

import com.example.challengekosmosirwin.data.api.ApiService
import com.example.challengekosmosirwin.data.entity.RickAndMortyResponse
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyDataSourceImplementation @Inject constructor(
    private val apiService: ApiService
) : RickAndMortyDataSource {
    override suspend fun getCharacters(page: String): Response<RickAndMortyResponse> {
        return apiService.getCharacters(page)
    }
}