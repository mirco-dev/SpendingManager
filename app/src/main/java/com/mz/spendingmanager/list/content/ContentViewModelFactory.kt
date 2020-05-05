package com.mz.spendingmanager.list.content

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ContentViewModelFactory(private val application: Application, private val mParam: Long) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContentViewModel(application, mParam) as T
    }
}