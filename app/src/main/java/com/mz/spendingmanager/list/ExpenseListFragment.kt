package com.mz.spendingmanager.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mz.spendingmanager.R


class ExpenseListFragment : Fragment() {

    companion object {
        fun newInstance() = ExpenseListFragment()
    }

    private lateinit var viewModel: ExpenseListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExpenseListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
