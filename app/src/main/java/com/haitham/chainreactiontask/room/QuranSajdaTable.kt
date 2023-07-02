package com.haitham.chainreactiontask.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.haitham.chainreactiontask.model.Sajda
import com.haitham.chainreactiontask.model.Surah


@Entity(tableName = "quran_sajda_table")
data class QuranSajdaTable(
    val hizbQuarter: Int,
    val juz: Int,
    val manzil: Int,
    @PrimaryKey val number: Int,
    val numberInSurah: Int,
    val page: Int,
    val ruku: Int,
    val sajda: Sajda,
    val surah: Surah,
    val text: String
)