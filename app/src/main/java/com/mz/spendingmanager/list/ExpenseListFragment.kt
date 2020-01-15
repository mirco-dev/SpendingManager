package com.mz.spendingmanager.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mz.spendingmanager.R
import com.mz.spendingmanager.model.Expense
import kotlinx.android.synthetic.main.list_fragment.*
import java.util.*
import kotlin.collections.ArrayList


class ExpenseListFragment : Fragment() {

    private lateinit var adapter: ExpenseListAdapter

    companion object {
        fun newInstance() = ExpenseListFragment()
    }

    private lateinit var viewModel: ExpenseListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //TODO DataBindingUtil
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpenseListViewModel::class.java)
        adapter = ExpenseListAdapter()
        rv_list.adapter = adapter

        viewModel.listExpense.observe(this, Observer {
            tv_num_elements.text = it.count().toString()
        })

        fab_create_new_item.setOnClickListener {
            val id : Long = (viewModel.getListExpense().count() + 1).toLong()
            val item = Expense(id, "Text item $id", Date())

            val newList = ArrayList<Expense>()
            newList.addAll(viewModel.getListExpense())

            newList.add(item)
            viewModel.setListExpense(newList)
        }
    }

}
