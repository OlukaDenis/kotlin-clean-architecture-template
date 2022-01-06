package com.mcash.client.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.mcash.client.R
import com.mcash.client.core.models.meals.MealEntity
import com.mcash.client.core.utils.toAmPmTime
import com.mcash.client.databinding.LayoutTrendingMealItemBinding

class TrendingMealAdapter(
    private val meals: List<MealEntity>
): RecyclerView.Adapter<TrendingMealAdapter.TrendingMealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingMealViewHolder {
        val binding = LayoutTrendingMealItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TrendingMealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendingMealViewHolder, position: Int) {
        val post = meals[position]
        post.let {
            holder.bindMeal(post)
        }
    }

    override fun getItemCount(): Int = meals.size

    inner class TrendingMealViewHolder(
        private val binding: LayoutTrendingMealItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindMeal(meal: MealEntity) {
            with(binding) {
                mtvMealName.text = meal.mealName
                mtvMealTag.text = meal.categoryName
                val rate = meal.rating as? Int ?: 0.0
                mtvMealRating.text = meal.rating.toString()

                val time = meal.creationDatetime.toAmPmTime()
                mtvSubInfo.text = "Posted on $time, ${meal.postAt}"

                val name = "${meal.firstName} ${meal.lastName}"
                mtvUserName.text = name
                mtvUserHandle.text = "@${meal.username}"


                mtvStartingAt.text = "Starting at $${meal.mealPrice}"

                if (meal.mealPic.isNotEmpty()) {
                    sivMealImage.load(meal.mealPic[0]) {
                        crossfade(true)
                        placeholder(R.drawable.ic_placeholder)
                        error(R.drawable.ic_placeholder)
                    }
                }

                sivUserImage.load(meal.profilePic) {
                    crossfade(true)
                    placeholder(R.drawable.ic_user)
                    error(R.drawable.ic_user)
                    transformations(CircleCropTransformation())
                }

            }
        }

    }

}