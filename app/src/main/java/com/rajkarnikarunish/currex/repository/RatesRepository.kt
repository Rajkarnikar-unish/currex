package com.rajkarnikarunish.currex.repository

import com.rajkarnikarunish.currex.utils.Constants.Companion.API_KEY
import com.rajkarnikarunish.currex.api.RetrofitInstance
import com.rajkarnikarunish.currex.database.CurreXDB
import com.rajkarnikarunish.currex.database.Rates
import com.rajkarnikarunish.currex.models.RatesResponse

class RatesRepository(
    val db: CurreXDB
) {

    suspend fun getRates() = RetrofitInstance.api.getAllRatesBaseUSD(apiKey = "Bearer $API_KEY")

    suspend fun upsertToRates(rates: Rates) = db.getCurrexDao().upsertToRates(rates)
    
    suspend fun upsertResponse(ratesResponse: RatesResponse) = db.getCurrexDao().upsertResponse(ratesResponse)
}