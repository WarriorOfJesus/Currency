package com.example.mycurrency.main_page.api.model

import com.google.gson.annotations.SerializedName

data class DataInfoResponse(
    @SerializedName("data")
    val data: CurrencyDataInfoResponse
)