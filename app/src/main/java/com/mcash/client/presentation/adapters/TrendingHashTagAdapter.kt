package com.mcash.client.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcash.client.core.models.hashtags.HashtagEntity
import com.mcash.client.databinding.LayoutHashtagItemBinding

class TrendingHashTagAdapter(
    private val hashtags: List<HashtagEntity>
): RecyclerView.Adapter<TrendingHashTagAdapter.HashTagViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HashTagViewHolder {
        val binding = LayoutHashtagItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return HashTagViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HashTagViewHolder, position: Int) {
        val hashtag = hashtags[position]
        hashtag.let {
            holder.bindPost(hashtag)
        }
    }

    override fun getItemCount(): Int = hashtags.size

    inner class HashTagViewHolder(
        private val binding: LayoutHashtagItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindPost(hashtag: HashtagEntity) {
            with(binding) {
               mtvHashtagName.text = hashtag.hashtag
                mtvPiesNum.text = "${hashtag.occurance} Pies"
            }
        }

    }

}