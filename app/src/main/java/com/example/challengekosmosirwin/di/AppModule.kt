package com.example.challengekosmosirwin.di

import com.example.challengekosmosirwin.data.AppConstants
import com.example.challengekosmosirwin.data.api.ApiService
import com.example.challengekosmosirwin.data.datasource.RickAndMortyDataSource
import com.example.challengekosmosirwin.data.datasource.RickAndMortyDataSourceImplementation
import com.example.challengekosmosirwin.ui.respository.RickAndMortyRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit {
        val httpClient = OkHttpClient().newBuilder().apply {

        }

        httpClient.apply {
            readTimeout(60,TimeUnit.SECONDS)
        }

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder()
            .baseUrl(AppConstants.APP_BASE_URL).client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    @Provides
    @Singleton
    fun providesApiServices(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesRickAndMortyDataSource(apiService: ApiService) : RickAndMortyDataSource {
        return RickAndMortyDataSourceImplementation(apiService)
    }

    @Provides
    @Singleton
    fun providesRickAndMortyRepository(rickAndMortyDataSource: RickAndMortyDataSource) : RickAndMortyRepository {
        return RickAndMortyRepository(rickAndMortyDataSource)
    }
}