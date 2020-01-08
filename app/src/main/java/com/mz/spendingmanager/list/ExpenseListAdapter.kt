package com.mz.spendingmanager.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mz.spendingmanager.R
import com.mz.spendingmanager.model.Expense
import com.mz.spendingmanager.utils.simpleFormat
import kotlinx.android.synthetic.main.expense_list_item.view.*

class ExpenseListAdapter : ListAdapter<Expense, ExpenseListAdapter.ItemViewholder>(
    ExpenseListDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        return ItemViewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.expense_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Expense) = with(itemView) {
            //Bind the data with View
            itemView.tv_id.text = String.format("%d", item.id)
            itemView.tv_creation_date.text = item.creationDate.simpleFormat()
            itemView.tv_text.text = item.title

            setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}