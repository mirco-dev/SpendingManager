package com.mz.spendingmanager.list.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mz.spendingmanager.R
import com.mz.spendingmanager.databinding.ContentFragmentBinding

class ContentFragment : Fragment() {

    companion object {
        fun newInstance() = ContentFragment()
    }

    private lateinit var binding: ContentFragmentBinding

    private lateinit var viewModel: ContentViewModel
    private var idItemSelected : Long =  0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ContentFragmentBinding>(inflater, R.layout.content_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        idItemSelected = arguments?.getLong("itemSelected") ?: 0L

        viewModel = ViewModelProvider(this, ContentViewModelFactory(activity?.application!!, idItemSelected)).get(ContentViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        itemSelected = arguments?.get("itemSelected") as Expense
//
//        viewModel = ViewModelProvider(this, ContentViewModelFactory(activity?.application!!, itemSelected)).get(ContentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
