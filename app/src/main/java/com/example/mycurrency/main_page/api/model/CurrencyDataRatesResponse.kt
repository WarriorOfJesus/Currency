package com.example.mycurrency.main_page.api.model

import com.google.gson.annotations.SerializedName

data class CurrencyDataRatesResponse(
    @SerializedName("AUD")
    val aud: Double?,
    @SerializedName("BGN")
    val bgn: Double?,
    @SerializedName("BRL")
    val brl: Double?,
    @SerializedName("CAD")
    val cad: Double?,
    @SerializedName("CHF")
    val chf: Double?,
    @SerializedName("CNY")
    val cny: Double?,
    @SerializedName("CZK")
    val czk: Double?,
    @SerializedName("DKK")
    val dkk: Double?,
    @SerializedName("EUR")
    val eur: Double?,
    @SerializedName("JPY")
    val jpy: Double?,
    @SerializedName("RUB")
    val rub: Double?,
    @SerializedName("USD")
    val usd: Double?
)
