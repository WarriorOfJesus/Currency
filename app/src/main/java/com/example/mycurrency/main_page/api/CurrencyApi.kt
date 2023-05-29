package com.example.mycurrency.main_page.api

import com.example.mycurrency.main_page.api.model.DataInfoResponse
import com.example.mycurrency.main_page.api.model.DataRatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("v1/currencies")
    suspend fun getCurrencyDataInfo(
        @Query("apikey") apiKey: String,
        @Query("currencies") currencies: String,
    ): DataInfoResponse


    @GET("v1/latest")
   suspend fun getCurrencyDataRates(
        @Query("apikey") apiKey: String,
        @Query("currencies") currencies: String,
        @Query("base_currency") baseCurrency: String
    ): DataRatesResponse
}