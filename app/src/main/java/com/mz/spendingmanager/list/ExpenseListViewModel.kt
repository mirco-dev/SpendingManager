package com.mz.spendingmanager.list

import android.app.Application
import androidx.lifecycle.*
import com.mz.spendingmanager.model.SpendingRepository
import com.mz.spendingmanager.model.SpendingRoomDatabase
import com.mz.spendingmanager.model.entity.Expense
import kotlinx.coroutines.launch

class ExpenseListViewModel(application: Application) : AndroidViewModel(application) {

    // The ViewModel maintains a reference to the repository to get data.
    private val repository: SpendingRepository
    // LiveData gives us updated words when they change.
    val listExpense : LiveData<List<Expense>>

    init {
        // Gets reference to ExpenseDao from SpendingRoomDatabase to construct
        // the correct SpendingRepository.
        val expenseDao = SpendingRoomDatabase.getDatabase(application, viewModelScope).expenseDao()
        repository = SpendingRepository(expenseDao)
        listExpense = repository.allExpense
    }

    fun insertExpense(expense: Expense) = viewModelScope.launch {
        repository.insert(expense)
    }

}
