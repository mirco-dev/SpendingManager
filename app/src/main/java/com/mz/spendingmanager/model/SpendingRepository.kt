package com.mz.spendingmanager.model

import androidx.lifecycle.LiveData
import com.mz.spendingmanager.model.dao.ExpenseDao
import com.mz.spendingmanager.model.entity.Expense

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class SpendingRepository(private val expenseDao: ExpenseDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allExpense: LiveData<List<Expense>> = expenseDao.getAllExpense()

    suspend fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }
}