package com.example.mycurrency.main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyDataRates(
    val aud: Double,
    val bgn: Double,
    val brl: Double,
    val cad: Double,
    val chf: Double,
    val cny: Double,
    val czk: Double,
    val dkk: Double,
    val eur: Double,
    val jpy: Double,
    val rub: Double,
    val usd: Double
):Parcelable
