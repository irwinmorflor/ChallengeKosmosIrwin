package com.example.challengekosmosirwin.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challengekosmosirwin.data.AppConstants
import com.example.challengekosmosirwin.data.entity.LocationInfo
import com.example.challengekosmosirwin.data.entity.OriginInfo
import com.example.challengekosmosirwin.data.entity.ResultsAPI
import com.example.challengekosmosirwin.data.entity.RickAndMortyResponse
import com.example.challengekosmosirwin.ui.respository.RickAndMortyRepository
import com.example.challengekosmosirwin.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickAndMortyViewModel @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {

    private val _characters: MutableStateFlow<ResourceState<RickAndMortyResponse>> = MutableStateFlow(ResourceState.Loading())
    val characters: StateFlow<ResourceState<RickAndMortyResponse>> = _characters

    var characterSelected: ResultsAPI = ResultsAPI(id = 0, name = "", status = "", species = "", type = "",
        gender = "", origin = OriginInfo(name = "", url = ""), location = LocationInfo(name = "", url = ""), image = "")

    init {
        getCharactersList(AppConstants.PAGE)
    }
    private fun getCharactersList(page: String){
        viewModelScope.launch(Dispatchers.IO) {
            rickAndMortyRepository.getCharacters(page)
                .collectLatest {charactersResponse ->
                    _characters.value = charactersResponse
                }
        }
    }
}