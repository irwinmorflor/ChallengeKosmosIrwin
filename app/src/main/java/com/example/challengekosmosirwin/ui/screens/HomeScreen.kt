package com.example.challengekosmosirwin.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.challengekosmosirwin.ui.components.ListCharacters
import com.example.challengekosmosirwin.ui.components.Loader
import com.example.challengekosmosirwin.ui.viewModel.RickAndMortyViewModel
import com.example.challengekosmosirwin.utilities.ResourceState

@Composable
fun HomeScreen(rickAndMortyViewModel: RickAndMortyViewModel = hiltViewModel()){

    val charactersResponse by rickAndMortyViewModel.characters.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when(charactersResponse){
            is ResourceState.Loading -> {
                Loader()
            }

            is ResourceState.Success -> {
                val response = (charactersResponse as ResourceState.Success).data
                ListCharacters(characters = response.results)
            }

            is ResourceState.Error -> {
                val response = (charactersResponse as ResourceState.Error).error
                Log.d("HomeScreen", response)
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}