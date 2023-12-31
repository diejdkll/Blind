package com.blind.data.source.local

import androidx.room.TypeConverter
import com.blind.util.DateUtil
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: String?): Date? {
        return timestamp?.let {DateUtil.dbDateFormat.parse(it)}
    }

    @TypeConverter
    fun toTimeStamp(date: Date?): String? {
        return DateUtil.dbDateFormat.format(date)
    }
}