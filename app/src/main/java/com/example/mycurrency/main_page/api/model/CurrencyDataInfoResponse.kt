package com.example.mycurrency.main_page.api.model

import com.google.gson.annotations.SerializedName

data class CurrencyDataInfoResponse(
    @SerializedName("AUD")
    val aud: AudResponse,
    @SerializedName("BGN")
    val bgn: BgnResponse,
    @SerializedName("BRL")
    val brl: BrlResponse,
    @SerializedName("CAD")
    val cad: CadResponse,
    @SerializedName("CHF")
    val chf: ChfResponse,
    @SerializedName("CNY")
    val cny: CnyResponse,
    @SerializedName("CZK")
    val czk: CzkResponse,
    @SerializedName("DKK")
    val dkk: DkkResponse,
    @SerializedName("EUR")
    val eur: EurResponse,
    @SerializedName("JPY")
    val jpy: JpyResponse,
    @SerializedName("RUB")
    val rub: RubResponse,
    @SerializedName("USD")
    val usd: UsdResponse
)
