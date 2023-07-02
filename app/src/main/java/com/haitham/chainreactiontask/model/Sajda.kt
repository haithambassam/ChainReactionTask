package com.haitham.chainreactiontask.model

import androidx.room.TypeConverter
import com.google.gson.Gson

data class Sajda(
    val id: Int,
    val obligatory: Boolean,
    val recommended: Boolean

) {

}

class SajdaTypeConverter {
    @TypeConverter
    fun fromSajda(sajda: Sajda): String {
        // Convert the Sajda object to a JSON string representation
        return Gson().toJson(sajda)
    }

    @TypeConverter
    fun toSajda(json: String): Sajda {
        // Convert the JSON string back to a Sajda object
        return Gson().fromJson(json, Sajda::class.java)
    }
}
