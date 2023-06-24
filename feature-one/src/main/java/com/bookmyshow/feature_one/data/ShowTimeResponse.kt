package com.bookmyshow.feature_one.data

import com.google.gson.annotations.SerializedName

data class ShowTimeResponse(

    @SerializedName("venues")
    val venues: List<VenuesItem>? = null
)