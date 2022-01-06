package com.mcash.client.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mcash.client.core.sealed.Resource
import com.mcash.client.core.sealed.TrendingHashtagState
import com.mcash.client.core.utils.Utils.Companion.resolveError
import com.mcash.client.domain.usecases.TrendingHashtagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject constructor(
    private val trendingHashtagUseCase: TrendingHashtagUseCase,
): ViewModel() {

    private val _trendingHashtags = MutableStateFlow<TrendingHashtagState>(TrendingHashtagState.Loading)
    val trendingHashtags get() = _trendingHashtags.asStateFlow()

    init {
        fetchTrandingHashtags()
    }

    /**
     * Fetches the list of trending hashtags from the use case.
     * Saves to the mutable state flow and submits to the UI
     */
    private fun fetchTrandingHashtags() {
        val parameter = TrendingHashtagUseCase.Param("279", "mJBUFJviEpP-bgAf7jfHCaHG0tjDdK8J4")
        viewModelScope.launch {
            trendingHashtagUseCase.invoke(parameter).collect {
                when(it) {
                    is Resource.Loading -> {}

                    is Resource.Success -> {
                        _trendingHashtags.value = TrendingHashtagState.Success(it.data)
                    }
                    is Resource.Error -> {
                        _trendingHashtags.value = TrendingHashtagState.Error(it.exception)
                    }
                }
            }

        }
    }
}