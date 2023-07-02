package com.haitham.chainreactiontask.di

import com.haitham.chainreactiontask.model.QuranSajdaResponse
import retrofit2.http.GET

interface ApiInterface {

    // This could be added as a Path to determine the language, however in this task I will stick to english
    @GET("sajda/en.asad")
    suspend fun getQuranSajdaList(): QuranSajdaResponse
}

