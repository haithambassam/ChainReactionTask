package com.haitham.chainreactiontask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.haitham.chainreactiontask.ui.data.QuranAyaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuranSajdaViewModel @Inject constructor(private val quranAyaRepository: QuranAyaRepository) : ViewModel() {

    val quranSajdaTableLD = quranAyaRepository.getQuranSajdaDBFlow().asLiveData()

    fun callGetSajdaApi() {
        viewModelScope.launch {
            quranAyaRepository.getQuranSajda()
        }

    }

}
