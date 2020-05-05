package com.mz.spendingmanager.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mz.spendingmanager.R
import com.mz.spendingmanager.databinding.ExpenseListItemBinding
import com.mz.spendingmanager.model.entity.Expense
import com.mz.spendingmanager.utils.simpleFormat
import kotlinx.android.synthetic.main.expense_list_item.view.*

class ExpenseListAdapter(
    private var expenseItems : List<Expense>,
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

    internal fun setExpense(list: List<Expense>) {
        this.expenseItems = list
        notifyDataSetChanged()
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return expenseItems.size
    }

    //the class is holding the list view
    class ViewHolder(bindingItem: ExpenseListItemBinding) : RecyclerView.ViewHolder(bindingItem.root) {
        //with(itemView) necessary to have setOnClickListener
        fun bindItems(item: Expense) {
            //todo binding
            itemView.tv_id.text = String.format("%d", item.id)
            itemView.tv_creation_date.text = item.creationDate.simpleFormat()
            itemView.tv_text.text = item.title

            val itemBundle = bundleOf("itemSelected" to item.id)
            itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_listFragment_to_contentFragment, itemBundle))
        }
    }


}