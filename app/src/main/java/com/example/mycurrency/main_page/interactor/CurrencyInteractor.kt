package com.example.mycurrency.main_page.interactor

import com.example.mycurrency.main_page.model.CurrencyDataInfo
import com.example.mycurrency.main_page.repository.CurrencyRemoteRepository

class CurrencyInteractor(
    private val remoteRepository: CurrencyRemoteRepository
) {
    suspend fun getCurrencyData(
        apiKey: String,
        currencies: String,
        baseCurrency: String
    ): CurrencyDataInfo {
        return remoteRepository.getCurrencyData(apiKey, currencies, baseCurrency)
    }
}