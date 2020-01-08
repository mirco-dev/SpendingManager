package com.mz.spendingmanager.utils

import java.text.SimpleDateFormat
import java.util.*

internal fun Date.simpleFormat() : String{
    val simpleFormat : SimpleDateFormat = SimpleDateFormat("HH:mm dd-MM-yyyy")
    return simpleFormat.format(this)
}