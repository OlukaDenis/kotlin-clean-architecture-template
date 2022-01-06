package com.mcash.client.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.mcash.client.R
import com.mcash.client.core.models.events.EventEntity
import com.mcash.client.core.utils.toAmPmTime
import com.mcash.client.databinding.LayoutTrendingEventItemBinding
import java.util.*

class TrendingEventAdapter(
    private val events: List<EventEntity>
): RecyclerView.Adapter<TrendingEventAdapter.TrendingEventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingEventViewHolder {
        val binding = LayoutTrendingEventItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TrendingEventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingEventViewHolder, position: Int) {
        val event = events[position]
        event.let {
            holder.bindEvent(event)
        }
    }

    override fun getItemCount(): Int = events.size

    inner class TrendingEventViewHolder(
        private val binding: LayoutTrendingEventItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindEvent(event: EventEntity) {
            with(binding) {
                mtvEventName.text = event.event_title
                mtvEventDate.text = "${event.post_at} - ${event.creation_datetime.toAmPmTime()}"
                mtvEventVenue.text = event.event_location

                val name = "${event.first_name} ${event.last_name}"
                mtvUserName.text = name
                mtvUserHandle.text = "@${event.user_name}"

                mtvEventType.text = "${event.event_type.capitalize(Locale.getDefault())} . "

                val members = event.vip_no_of_participants.toInt() + event.regular_no_of_participants.toInt()
                mtvEventMembers.text = " $members members left"


                if (event.event_type.equals("private", ignoreCase = true)) {

                    if (event.event_free_paid.equals("free", ignoreCase = true)) {
                        btnEventPrice.text = "Free"
                    } else {
                        btnEventPrice.text = "$ ${event.regular_event_price}"
                    }

                } else {

                    if (event.event_free_paid.equals("free", ignoreCase = true)) {
                        btnEventPrice.text = "Free"
                    } else {
                        btnEventPrice.text = "$ ${event.regular_event_price}"
                    }

                }

                if (event.event_pic.isNotEmpty()) {
                    sivEventImage.load(event.event_pic[0]) {
                        crossfade(true)
                        placeholder(R.drawable.ic_placeholder)
                        error(R.drawable.ic_placeholder)
                    }
                }

                if (event.profile_pic.isNotEmpty()) {
                    sivUserImage.load(event.profile_pic[0]) {
                        crossfade(true)
                        placeholder(R.drawable.ic_user)
                        error(R.drawable.ic_user)
                        transformations(CircleCropTransformation())
                    }
                } else {
                    sivUserImage.load(R.drawable.ic_user) {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }
                }

            }
        }

    }
}
