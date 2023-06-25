package com.bookmyshow.common_ui

import java.text.SimpleDateFormat
import java.util.*

fun getDayDateMonthFromDate(dateString: String): Triple<String, String, String> {
    val inputFormat = SimpleDateFormat("dd MMM, yyyy", Locale.ENGLISH)
    val date = inputFormat.parse(dateString)

    val dayFormat = SimpleDateFormat("EEE", Locale.ENGLISH)
    val dayName = dayFormat.format(date)

    val dateFormat = SimpleDateFormat("dd", Locale.ENGLISH)
    val dateOfMonth = dateFormat.format(date)

    val monthFormat = SimpleDateFormat("MMM", Locale.ENGLISH)
    val month = monthFormat.format(date)

    return Triple(dayName, dateOfMonth, month)
}
