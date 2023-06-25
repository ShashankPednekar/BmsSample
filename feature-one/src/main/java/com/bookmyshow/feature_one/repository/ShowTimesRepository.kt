package com.bookmyshow.feature_one.repository

import android.util.Log
import com.bookmyshow.core.NetworkProvider
import com.bookmyshow.feature_one.data.ShowTimeResponse
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

    suspend fun fetchShowDetails(): ShowTimeResponse {
        val response = api.getShowTimes()
        Log.d(TAG, "fetchShowDetails: ${response.venues?.size}")
        return response
    }
}