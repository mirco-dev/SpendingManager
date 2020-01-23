package com.mz.spendingmanager.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mz.spendingmanager.R
import com.mz.spendingmanager.databinding.ExpenseListFragmentBinding
import com.mz.spendingmanager.model.Expense
import kotlinx.android.synthetic.main.expense_list_fragment.*
import java.util.*
import kotlin.collections.ArrayList


class ExpenseListFragment : Fragment() {

    private lateinit var adapter: ExpenseListAdapter
    private lateinit var binding: ExpenseListFragmentBinding

    companion object {
        fun newInstance() = ExpenseListFragment()
    }

    private lateinit var viewModel: ExpenseListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //ListFragmentBinding is generated from layout name -> expense_list_fragment
        binding = DataBindingUtil.inflate<ExpenseListFragmentBinding>(inflater, R.layout.expense_list_fragment, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(ExpenseListViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ExpenseListAdapter(listOf(), binding.lifecycleOwner!!)
        rv_list.adapter = adapter

        viewModel.listExpense.observe(this, Observer {
            //databinding
            viewModel.count.value = it.size.toString()
        })

        fab_create_new_item.setOnClickListener {
            val id : Long = (viewModel.getListExpense().count() + 1).toLong()
            val item = Expense(id, "Text item $id", Date())

            val newList = ArrayList<Expense>()
            newList.addAll(viewModel.getListExpense())

            newList.add(item)
            viewModel.setListExpense(newList)
            rv_list.adapter = ExpenseListAdapter(newList, binding.lifecycleOwner!!)
        }
    }

}
