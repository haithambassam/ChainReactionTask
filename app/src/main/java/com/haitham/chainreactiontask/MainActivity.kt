package com.haitham.chainreactiontask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.haitham.chainreactiontask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Change ActionBar title
        supportActionBar?.title = "Quran Sajdas"
    }
}