package com.haitham.chainreactiontask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.haitham.chainreactiontask.databinding.ItemSajdaAyaBinding
import com.haitham.chainreactiontask.room.QuranSajdaTable
import com.haitham.chainreactiontask.ui.data.SharePlatforms

class QuranSajdaRVAdapter(val onAyaShareBTClicked: (SharePlatforms, QuranSajdaTable) -> (Unit)) :
    ListAdapter<QuranSajdaTable, QuranSajdaRVAdapter.QuranSajdaViewHolder>(QuranSajdaDiffCallback()) {

    class QuranSajdaViewHolder(val binding: ItemSajdaAyaBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranSajdaViewHolder {
        val binding = ItemSajdaAyaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuranSajdaViewHolder(binding).apply { prepareListeners(this) }
    }

    private fun prepareListeners(viewHolder: QuranSajdaViewHolder) {

        viewHolder.binding.facebookShareIV.setOnClickListener {
            onAyaShareBTClicked(SharePlatforms.Facebook, getItem(viewHolder.adapterPosition))
        }
        viewHolder.binding.instagramShareIV.setOnClickListener {
            onAyaShareBTClicked(SharePlatforms.Instagram, getItem(viewHolder.adapterPosition))
        }
    }

    override fun onBindViewHolder(holder: QuranSajdaViewHolder, position: Int) {
        val aya = getItem(position)
        holder.binding.apply {
            surahNameTV.text = aya.surah.englishName
            ayaNumberTV.text = aya.surah.number.toString()
        }
    }


    class QuranSajdaDiffCallback : DiffUtil.ItemCallback<QuranSajdaTable>() {
        override fun areItemsTheSame(oldItem: QuranSajdaTable, newItem: QuranSajdaTable): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: QuranSajdaTable, newItem: QuranSajdaTable): Boolean {
            return true
        }
    }
}


