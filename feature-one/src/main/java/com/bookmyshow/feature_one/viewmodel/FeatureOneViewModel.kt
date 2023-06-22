package com.bookmyshow.feature_one.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bookmyshow.feature_one.repository.ShowTimesRepository
import javax.inject.Inject

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
class FeatureOneViewModel @Inject constructor(
    private val showTimesRepository: ShowTimesRepository
) : ViewModel() {
    private val TAG = "FeatureOneViewModel"
    fun test() {
        Log.d(TAG, "test ")
    }
}