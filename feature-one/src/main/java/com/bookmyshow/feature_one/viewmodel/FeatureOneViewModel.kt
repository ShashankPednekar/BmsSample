package com.bookmyshow.feature_one.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
class FeatureOneViewModel @Inject constructor(
    private val showTimesRepository: ShowTimesRepository
) : ViewModel() {
    private val TAG = "FeatureOneViewModel"
    fun test() {
        viewModelScope.launch {
            showTimesRepository.fetchShowDetails()
        }
    }
}