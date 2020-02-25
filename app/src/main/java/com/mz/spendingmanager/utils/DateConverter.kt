package com.mz.spendingmanager.utils

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(timestamp : Long?) : Date {
        //same as -> return if (timestamp == null) Date() else Date(timestamp)
        return timestamp?.let { Date(it) } ?: Date()
    }

    @TypeConverter
    fun toTimestamp(date : Date?) : Long{
        return date?.time ?: 0L
    }
}