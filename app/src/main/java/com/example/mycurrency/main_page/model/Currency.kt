package com.example.mycurrency.main_page.model

import android.os.Parcelable
import com.example.mycurrency.main_page.api.model.CurrencyDataRatesResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
    val symbol: String?,
    val name: String?,
    val symbolNative: String?,
    val decimalDigits: Int?,
    val rounding: Int,
    val code: String?,
    val namePlural: String?,
    val rates : Double?
) : Parcelable
