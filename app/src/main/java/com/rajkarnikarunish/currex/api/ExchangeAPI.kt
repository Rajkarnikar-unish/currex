package com.rajkarnikarunish.currex.api

import com.rajkarnikarunish.currex.Constants.Companion.API_KEY
import com.rajkarnikarunish.currex.models.RatesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ExchangeAPI {
    @GET("latest/USD")
    suspend fun getAllRatesBaseUSD(
        @Header("Authorization") apiKey: String
    ) : Response<RatesResponse>
}