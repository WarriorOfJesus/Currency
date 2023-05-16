package com.example.mycurrency.main_page.api.model

import com.google.gson.annotations.SerializedName

data class AudResponse(
    @SerializedName("symbol")
    val symbol: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol_native")
    val symbolNative: String?,
    @SerializedName("decimal_digits")
    val decimalDigits: Int?,
    @SerializedName("rounding")
    val rounding: Int,
    @SerializedName("code")
    val code: String?,
    @SerializedName("name_plural")
    val namePlural: String?
)
