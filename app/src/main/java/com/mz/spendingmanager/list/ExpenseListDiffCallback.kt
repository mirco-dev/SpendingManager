package com.mz.spendingmanager.list

import androidx.recyclerview.widget.DiffUtil
import com.mz.spendingmanager.model.Expense

class ExpenseListDiffCallback : DiffUtil.ItemCallback<Expense>() {
    override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
        return oldItem.id == newItem.id
    }
}