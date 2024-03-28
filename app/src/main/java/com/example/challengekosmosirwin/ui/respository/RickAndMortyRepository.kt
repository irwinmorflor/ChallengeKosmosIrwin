package com.example.challengekosmosirwin.ui.respository

import com.example.challengekosmosirwin.data.datasource.RickAndMortyDataSource
import com.example.challengekosmosirwin.data.entity.RickAndMortyResponse
import com.example.challengekosmosirwin.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val rickAndMortyDataSource: RickAndMortyDataSource
) {
    suspend fun getCharacters(page: String) : Flow<ResourceState<RickAndMortyResponse>>{
        return  flow {
             emit(ResourceState.Loading())

            val response = rickAndMortyDataSource.getCharacters(page)

            if (response.isSuccessful && response.body() != null)
            {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error al obtener la lista de personajes"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e?.localizedMessage?:"Error en el flow"))
        }
    }
}