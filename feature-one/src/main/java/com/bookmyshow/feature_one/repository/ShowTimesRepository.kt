package com.bookmyshow.feature_one.repository

import android.util.Log
import com.bookmyshow.core.NetworkProvider
import javax.inject.Inject

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
class ShowTimesRepository @Inject constructor(
    private val networkProvider: NetworkProvider
) {
    private val TAG = "ShowTimesRepository"

    private val api: ShowTimesAPI
        get() = networkProvider.getApi(
            apiClass = ShowTimesAPI::class.java,
            baseUrl = "https://demo2782755.mockable.io"
        )

    suspend fun fetchShowDetails() {
        val response = api.getShowTimes()
        Log.d(TAG, "fetchShowDetails: ${response.venues?.size}")
    }
}