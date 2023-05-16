package com.example.mycurrency.main_page.api.model

import com.google.gson.annotations.SerializedName

data class DataRatesResponse(
    @SerializedName("data")
    val data : CurrencyDataRatesResponse
)