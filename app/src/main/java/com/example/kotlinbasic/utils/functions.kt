package com.example.kotlinbasic.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getFormattedDateTime(millis: Long, format: String) =
    SimpleDateFormat(format, Locale.getDefault()).format(Date())