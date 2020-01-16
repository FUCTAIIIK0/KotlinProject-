package ru.skillbranch.kotlininencive.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateformat = SimpleDateFormat(pattern, Locale("ru"))

    return dateformat.format(this)
}