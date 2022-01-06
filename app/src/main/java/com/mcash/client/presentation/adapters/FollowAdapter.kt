package com.mcash.client.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.mcash.client.R
import com.mcash.client.core.models.profiles.PiemateModelEntity
import com.mcash.client.databinding.LayoutFollowPiemateItemBinding

class FollowAdapter(
    private val list: List<PiemateModelEntity>
): RecyclerView.Adapter<FollowAdapter.FollowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowViewHolder {
        val binding = LayoutFollowPiemateItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FollowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowViewHolder, position: Int) {
        val post = list[position]
        post.let {
            holder.bindPost(post)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class FollowViewHolder(
        private val binding: LayoutFollowPiemateItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindPost(piemate: PiemateModelEntity) {
            with(binding) {
                val name = "${piemate.firstName} ${piemate.lastName}"

                if (piemate.status.equals("2")) {
                    civVerified.visibility = View.VISIBLE
                } else {
                    civVerified.visibility = View.GONE
                }

                mtvPieName.text = name
                mtvFollowers.text = "${piemate.followerCount} followers"
                mtvPieHandle.text = "@${piemate.username}"
                mtvPieDesc.text = piemate.profileStatus

                sivPieImage.load(piemate.profilePic) {
                    crossfade(true)
                    placeholder(R.drawable.ic_user)
                    error(R.drawable.ic_user)
                    transformations(CircleCropTransformation())
                }
            }
        }

    }

}