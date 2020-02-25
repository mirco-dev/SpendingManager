package com.mz.spendingmanager.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mz.spendingmanager.R
import com.mz.spendingmanager.databinding.ExpenseListFragmentBinding
import com.mz.spendingmanager.model.entity.Expense
import com.mz.spendingmanager.utils.simpleFormat
import kotlinx.android.synthetic.main.expense_list_fragment.*
import java.util.*


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
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel = ViewModelProvider(this).get(ExpenseListViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = ExpenseListAdapter(listOf(), viewLifecycleOwner)
        rv_list.adapter = adapter

        viewModel.listExpense.observe(viewLifecycleOwner, Observer {
            // Update the cached copy of the words in the adapter.
            it?.let { adapter.setExpense(it) }
        })

        fab_create_new_item.setOnClickListener {
            val item = Expense(
                "Text item " + Date().simpleFormat()
            )
            viewModel.insertExpense(item)
        }
    }

}
