package com.bookmyshow.feature_one.data

import com.google.gson.annotations.SerializedName

data class VenuesItem(

    @SerializedName("name")
    val name: String = "",

    @SerializedName("showtimes")
    val showTimes: List<ShowtimesItem>? = null,

    @SerializedName("showDate")
    val showDate: String = "",

    var isSelected: Boolean = false,
)