package com.rajkarnikarunish.currex

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajkarnikarunish.currex.database.Rates
import com.rajkarnikarunish.currex.models.RatesResponse
import com.rajkarnikarunish.currex.repository.RatesRepository
import com.rajkarnikarunish.currex.utils.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response

class RatesViewModel(
    val ratesRepository: RatesRepository
) : ViewModel() {

    val rates: MutableLiveData<Resource<RatesResponse>> = MutableLiveData()

    init {
        getRates()
    }

    fun getRates(): Job {
        return viewModelScope.launch {
            rates.postValue(Resource.Loading())
            val response = ratesRepository.getRates()
            rates.postValue(handleRatesResponse(response))
        }
    }

    private fun handleRatesResponse(resultResponse: Response<RatesResponse>) : Resource<RatesResponse> {
        if (resultResponse.isSuccessful) {
            resultResponse.body()?.let { result ->
                viewModelScope.launch { ratesRepository.upsertResponse(result) }
                result.conversionRates.forEach { (currency, rate) -> 
                    viewModelScope.launch {
                        ratesRepository.upsertToRates(Rates(currency, rate))
                    }
                }
                return Resource.Success(result)
            }
        }
        return Resource.Error(resultResponse.message())
    }
}