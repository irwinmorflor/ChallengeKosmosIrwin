package com.example.challengekosmosirwin.data.entity

data class RickAndMortyResponse(
    val info: InfoAPI,
    val results: List<ResultsAPI>
)
data class InfoAPI(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String? = null
)

data class ResultsAPI(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginInfo,
    val location: LocationInfo,
    val image: String
)

data class OriginInfo(
    val name: String,
    val url: String
)

data class LocationInfo(
    val name: String,
    val url: String
)