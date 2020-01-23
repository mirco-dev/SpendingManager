package com.mz.spendingmanager.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.mz.spendingmanager.R
import com.mz.spendingmanager.databinding.ExpenseListItemBinding
import com.mz.spendingmanager.model.Expense
import com.mz.spendingmanager.utils.simpleFormat
import kotlinx.android.synthetic.main.expense_list_item.view.*

class ExpenseListAdapter(
    private val expenseItems : List<Expense>,
    private val lifecycleOwner : LifecycleOwner
) : RecyclerView.Adapter<ExpenseListAdapter.ViewHolder>() {

    private lateinit var binding: ExpenseListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.expense_list_item,
            parent,
            false
        )

        binding.lifecycleOwner = lifecycleOwner
        return ViewHolder(binding)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(expenseItems[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return expenseItems.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: ExpenseListItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        //with(itemView) necessary to have setOnClickListener
        fun bindItems(item: Expense) = with(itemView){
            itemView.tv_id.text = String.format("%d", item.id)
            itemView.tv_creation_date.text = item.creationDate.simpleFormat()
            itemView.tv_text.text = item.title

            setOnClickListener {
                Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
            }
        }
    }


}