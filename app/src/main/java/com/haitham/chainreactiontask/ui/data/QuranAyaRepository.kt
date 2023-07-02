package com.haitham.chainreactiontask.ui.data

import android.util.Log
import com.haitham.chainreactiontask.di.ApiInterface
import com.haitham.chainreactiontask.room.QuranDao
import com.haitham.chainreactiontask.room.QuranSajdaTable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


class QuranAyaRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val dao: QuranDao
) {

    suspend fun getQuranSajda() {
        try {
            // Call the API if the database is Empty
            val response = apiInterface.getQuranSajdaList()
            if (response.code == 200) dao.insertAllQuranSajdas(response.data.ayahs)
        } catch (e: Exception) {
            Log.e("error", e.toString())
        }
    }

    fun getQuranSajdaDBFlow(): Flow<List<QuranSajdaTable>> {
        return dao.getAllQuranSajda()
    }

}
