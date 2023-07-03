package com.haitham.chainreactiontask.model

import com.haitham.chainreactiontask.model.Sajda
import com.haitham.chainreactiontask.model.Surah


data class Ayah(
    val hizbQuarter: Int,
    val juz: Int,
    val manzil: Int,
    val number: Int,
    val numberInSurah: Int,
    val page: Int,
    val ruku: Int,
    val sajda: Sajda,
    val surah: Surah,
    val text: String
)
