package com.mz.spendingmanager.model

import java.util.*

data class Expense(
    val id : Long,
    val title : String,
    val creationDate : Date
)