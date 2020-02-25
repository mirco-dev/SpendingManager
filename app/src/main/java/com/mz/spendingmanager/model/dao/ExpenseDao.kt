package com.mz.spendingmanager.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mz.spendingmanager.model.entity.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * from expense_table ORDER BY id")
    fun getAllExpense() : LiveData<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expense: Expense)

    @Query("DELETE FROM expense_table")
    suspend fun deleteAll()
}