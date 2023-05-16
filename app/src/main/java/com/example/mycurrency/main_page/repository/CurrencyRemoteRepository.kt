package com.example.mycurrency.main_page.repository

import com.example.mycurrency.main_page.api.CurrencyApi
import com.example.mycurrency.main_page.model.CurrencyConverter
import com.example.mycurrency.main_page.model.CurrencyDataInfo
import com.example.mycurrency.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import timber.log.Timber

class CurrencyRemoteRepository(
    private val api: CurrencyApi
) : CurrencyRepository {
    override suspend fun getCurrencyData(
        apiKey: String,
        currencies: String,
        baseCurrency: String
    ): CurrencyDataInfo {
        val coroutineScope = CoroutineScope(Dispatchers.Main)
        val response = coroutineScope.async {
            api.getCurrencyDataInfo(
                Constants.API_KEY,
                Constants.CURRENCIES
            )
        }.await()
        Timber.i("--->> response : $response")
        val rate = coroutineScope.async { api.getCurrencyDataRates(Constants.API_KEY, Constants.CURRENCIES) }
            .await()
        Timber.i("--->> rate : $rate")
        return CurrencyConverter.fromNetwork(response, rate)
    }

}
