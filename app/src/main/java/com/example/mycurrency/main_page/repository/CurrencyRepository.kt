package com.example.mycurrency.main_page.repository

import com.example.mycurrency.main_page.model.CurrencyDataInfo

interface CurrencyRepository {
suspend fun getCurrencyData(apiKey: String, currencies: String, baseCurrency:String) : CurrencyDataInfo?
}

