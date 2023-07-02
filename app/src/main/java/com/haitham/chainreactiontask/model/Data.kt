package com.haitham.chainreactiontask.model

import com.haitham.chainreactiontask.room.QuranSajdaTable


data class Data(
    val ayahs: List<QuranSajdaTable>,
    val edition: Edition
)