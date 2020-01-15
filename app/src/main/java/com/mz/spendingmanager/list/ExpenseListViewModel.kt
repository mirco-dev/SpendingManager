package com.mz.spendingmanager.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mz.spendingmanager.model.Expense

class ExpenseListViewModel : ViewModel() {
    val listExpense : MutableLiveData<List<Expense>> = MutableLiveData()

    fun setListExpense(result: List<Expense>) {
        listExpense.value = result
    }

    fun getListExpense(): List<Expense> {
        //return current display state or empty string if value is null
        //see "Elvis Operator"
        return listExpense.value ?: emptyList()
    }

    fun getCount() : Int {
        return listExpense.value?.size ?: 0
    }
}
