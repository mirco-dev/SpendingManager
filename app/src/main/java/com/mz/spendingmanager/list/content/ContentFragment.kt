package com.mz.spendingmanager.list.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.mz.spendingmanager.R
import com.mz.spendingmanager.model.Expense
import kotlinx.android.synthetic.main.list_fragment.*
import java.util.*
import kotlin.collections.ArrayList

class ContentFragment : Fragment() {

    companion object {
        fun newInstance() = ContentFragment()
    }

    private lateinit var viewModel: ContentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.content_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContentViewModel::class.java)

        viewModel.listExpense.observe(this, androidx.lifecycle.Observer {
            tv_num_elements.text = it.count().toString()
        })

        fab_create_new_item.setOnClickListener {
            val id : Long = (viewModel.getListExpense().count() + 1).toLong()
            val item = Expense(id, "Text item $id", Date())

            val newList = ArrayList<Expense>()
            newList.addAll(viewModel.getListExpense())

            newList.add(1,item)
            viewModel.setListExpense(newList)
        }
    }

}
