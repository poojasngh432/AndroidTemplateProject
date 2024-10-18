package com.droidspiration.androidtemplateproject.network

import com.droidspiration.androidtemplateproject.data.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("public/collection/v1/search")
    suspend fun getRecords(
        @Query("q") query: String,
        @Query("hasImages") hasImages: Boolean = true
    ): Result<String>

    @GET("public/collection/v1/objects/{id}")
    suspend fun getArtPieceData(@Path("id") id: Int): Result<String>
}