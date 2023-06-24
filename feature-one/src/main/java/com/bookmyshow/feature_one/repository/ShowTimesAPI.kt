package com.bookmyshow.feature_one.repository

import com.bookmyshow.feature_one.data.ShowTimeResponse
import retrofit2.http.GET

/**
 * Created by Akshansh Dhing on 12/10/22.
 */
interface ShowTimesAPI {

    @GET("/movie_showtimes")
    suspend fun getShowTimes(): ShowTimeResponse
}