package com.mcash.client.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mcash.client.presentation.adapters.*
import com.mcash.client.core.models.hashtags.HashtagEntity
import com.mcash.client.core.sealed.TrendingHashtagState
import com.mcash.client.databinding.ActivityMainBinding
import com.mcash.client.domain.usecases.LocalUserUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var localUserUseCase: LocalUserUseCase

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = localUserUseCase.getUser()
        Timber.d("User: $user")
        binding.userName.text = "${user.firstName} ${user.lastName}"

        with(viewModel) {

            lifecycleScope.launchWhenStarted {
                trendingHashtags.collect {
                    when (it) {
                        is TrendingHashtagState.Loading -> {
                        }
                        is TrendingHashtagState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
                        }
                        is TrendingHashtagState.Success -> {
                            populateHashtags(it.data)
                        }
                    }
                }
            }
        }


    }

    /**
     * Populate hashtags to the recyclerview
     */
    private fun populateHashtags(hashtags: List<HashtagEntity>) {
        val firstThree = hashtags.take(3)
        val trendingManager = LinearLayoutManager(this)
        val trendingAdapter = TrendingHashTagAdapter(firstThree)

        with(binding) {
            trendingHashtagsRecycler.apply {
                layoutManager = trendingManager
                adapter = trendingAdapter
            }
        }
    }

}