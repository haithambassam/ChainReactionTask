package com.haitham.chainreactiontask.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuranDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllQuranSajdas(objects: List<QuranSajdaTable>)


    @Query("SELECT * FROM quran_sajda_table")
    fun getAllQuranSajda(): Flow<List<QuranSajdaTable>>

}