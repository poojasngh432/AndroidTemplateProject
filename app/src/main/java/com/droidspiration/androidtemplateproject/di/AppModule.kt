package com.droidspiration.androidtemplateproject.di

import com.droidspiration.androidtemplateproject.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// (for global singletons): This could provide Retrofit, OkHttpClient, and the database instance.

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://collectionapi.metmuseum.org/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}