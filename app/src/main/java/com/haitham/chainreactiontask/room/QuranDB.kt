package com.haitham.chainreactiontask.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.haitham.chainreactiontask.model.SajdaTypeConverter
import com.haitham.chainreactiontask.model.SurahTypeConverter

@TypeConverters(SajdaTypeConverter::class, SurahTypeConverter::class)
@Database([QuranSajdaTable::class], version = 1)
abstract class QuranDB : RoomDatabase() {
    abstract fun getQuranDao(): QuranDao
}