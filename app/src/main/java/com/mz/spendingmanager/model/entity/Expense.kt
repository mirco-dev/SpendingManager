package com.mz.spendingmanager.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mz.spendingmanager.utils.DateConverter
import java.util.*

@Entity(tableName = "expense_table")
class Expense(
    @ColumnInfo(name = "title") val title : String
) {
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0

    @TypeConverters(DateConverter::class)
    @ColumnInfo(name = "creation_date")
    var creationDate : Date = Date()
}