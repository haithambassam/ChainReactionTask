package com.haitham.chainreactiontask.model

import androidx.room.TypeConverter
import com.google.gson.Gson

data class Surah(
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
)

class SurahTypeConverter {
    @TypeConverter
    fun fromSurah(surah: Surah): String {
        // Convert the Surah object to a JSON string representation
        return Gson().toJson(surah)
    }

    @TypeConverter
    fun toSurah(json: String): Surah {
        // Convert the JSON string back to a Surah object
        return Gson().fromJson(json, Surah::class.java)
    }
}