package com.mcash.client.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mcash.client.R
import com.mcash.client.core.models.profiles.PiemateModelEntity
import com.mcash.client.databinding.LayoutPiemateItemBinding

class InviteAdapter(
    private val piemateList: List<PiemateModelEntity>
): RecyclerView.Adapter<InviteAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = LayoutPiemateItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = piemateList[position]
        post.let {
            holder.bindPost(post)
        }
    }

    override fun getItemCount(): Int = piemateList.size

    inner class PostViewHolder(
        private val binding: LayoutPiemateItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindPost(piemate: PiemateModelEntity) {
            with(binding) {
                val name = "${piemate.firstName} ${piemate.lastName}"
                mtvProfileName.text = name
                mtvFollowerCount.text = "${piemate.followerCount} Piemates"

                civProfilePic.load(piemate.profilePic) {
                    crossfade(true)
                    placeholder(R.drawable.ic_placeholder)
                    error(R.drawable.ic_placeholder)
                }
            }
        }

    }

}