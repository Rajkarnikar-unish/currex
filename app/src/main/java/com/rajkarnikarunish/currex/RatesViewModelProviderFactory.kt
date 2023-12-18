package com.rajkarnikarunish.currex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajkarnikarunish.currex.repository.RatesRepository

class RatesViewModelProviderFactory(
    val ratesRepository: RatesRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RatesViewModel(ratesRepository) as T
    }
}