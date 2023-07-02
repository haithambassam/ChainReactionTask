package com.haitham.chainreactiontask.di

import android.content.Context
import androidx.room.Room
import com.haitham.chainreactiontask.room.QuranDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.alquran.cloud/v1/"

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    @Singleton
    fun getApiClient(): ApiInterface {
        val client: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return client.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun getQuranDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuranDB::class.java, "quran_database").build()

    @Provides
    @Singleton
    fun getQuranDao(quranDB: QuranDB) = quranDB.getQuranDao()

}