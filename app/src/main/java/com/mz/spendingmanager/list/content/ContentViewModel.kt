package com.mz.spendingmanager.list.content

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mz.spendingmanager.model.SpendingRepository
import com.mz.spendingmanager.model.database.SpendingRoomDatabase
import com.mz.spendingmanager.model.entity.Expense

class ContentViewModel(application: Application, idExpense: Long) : AndroidViewModel(application){
    // The ViewModel maintains a reference to the repository to get data.
    private val repository: SpendingRepository
    // LiveData gives us updated words when they change.
    val expenseSelected : LiveData<Expense>

    init {
        // Gets reference to ExpenseDao from SpendingRoomDatabase to construct
        // the correct SpendingRepository.
        val expenseDao = SpendingRoomDatabase.getDatabase(application, viewModelScope).expenseDao()
        repository = SpendingRepository(expenseDao)
        expenseSelected = repository.getExpense(idExpense)
    }

}
