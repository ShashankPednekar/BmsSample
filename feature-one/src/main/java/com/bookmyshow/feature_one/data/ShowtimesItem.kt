package com.bookmyshow.feature_one.data

import com.google.gson.annotations.SerializedName

data class ShowtimesItem(

    @SerializedName("showDateCode")
    val showDateCode: Long? = null,

    @SerializedName("showTime")
    val showTime: String? = null
)