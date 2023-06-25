package com.bookmyshow.common_ui

import java.text.SimpleDateFormat
import java.util.*

fun getDayDateMonthFromDate(dateString: String): Triple<String, String, String> {
    val modifiedDateString = dateString.replace("\\b(\\d+)(st|nd|rd|th)\\b".toRegex()) {
            matchResult -> matchResult.groupValues[1]
    }

    val inputFormat = SimpleDateFormat("dd MMM, yyyy", Locale.ENGLISH)
    val date = inputFormat.parse(modifiedDateString)

    val dayFormat = SimpleDateFormat("EEE", Locale.ENGLISH)
    val dayName = dayFormat.format(date)

    val dateFormat = SimpleDateFormat("dd", Locale.ENGLISH)
    val dayOfMonth = dateFormat.format(date)

    val monthFormat = SimpleDateFormat("MMM", Locale.ENGLISH)
    val month = monthFormat.format(date)

    return Triple(dayName, dayOfMonth, month)
}
