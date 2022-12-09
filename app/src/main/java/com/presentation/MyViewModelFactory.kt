package com.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.domain.GetUsefulActivityUseCase


class MyViewModelFactory(private val useCase: GetUsefulActivityUseCase) : ViewModelProvider.Factory{


   override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(useCase) as T
    }
}

