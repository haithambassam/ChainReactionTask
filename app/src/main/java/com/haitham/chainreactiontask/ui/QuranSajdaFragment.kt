package com.haitham.chainreactiontask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.haitham.chainreactiontask.*
import com.haitham.chainreactiontask.databinding.FragmentQuranSajdaBinding
import com.haitham.chainreactiontask.ui.data.SharePlatforms
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuranSajdaFragment : Fragment() {
    // Binding
    private lateinit var binding: FragmentQuranSajdaBinding

    // ViewModel
    private val quranSajdaViewModel by viewModels<QuranSajdaViewModel>()

    private val quranSajdaRVAdapter: QuranSajdaRVAdapter = QuranSajdaRVAdapter { sharePlatform, aya ->
        when (sharePlatform) {
            is SharePlatforms.Facebook -> {
                shareFacebook("${aya.text} \n  number = ${aya.surah.number}")
            }
            is SharePlatforms.Instagram -> {
                shareOnInstagram( "${aya.text} \n  number = ${aya.surah.number}")
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentQuranSajdaBinding.inflate(layoutInflater, container, false)
        prepareSajdaRV()
        observeFragmentViewModel()
        return binding.root
    }

    private fun prepareSajdaRV() {
        binding.sajdaRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = quranSajdaRVAdapter
            addItemDecoration(QuranSajdaDecorator(10))
        }

    }

    private fun observeFragmentViewModel() {
        quranSajdaViewModel.quranSajdaTableLD.observe(viewLifecycleOwner) {
            if (it.isNullOrEmpty()) {
                binding.noDataTV.visibility = View.VISIBLE
                // Call API
                quranSajdaViewModel.callGetSajdaApi()
            } else {
                binding.noDataTV.visibility = View.GONE
                quranSajdaRVAdapter.submitList(it)
            }
        }
    }

}