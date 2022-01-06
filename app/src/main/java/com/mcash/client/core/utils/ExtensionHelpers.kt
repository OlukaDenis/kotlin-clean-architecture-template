package com.mcash.client.core.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * An extension method that extracts time in AM or PM from a provide datetime string
 * @return formatted time string
 */
fun String.toAmPmTime(): String? {
    val tokenizer = StringTokenizer(this)
    val date = tokenizer.nextToken()
    val time = tokenizer.nextToken()

    val sdf = SimpleDateFormat("KK:mm:ss", Locale.getDefault())
    val sdfs = SimpleDateFormat("hh:mm a", Locale.getDefault())

    return try {
        val m = sdf.parse(time)
        sdfs.format(m!!)
    } catch (e: ParseException) {
        e.printStackTrace()
        null
    }
}