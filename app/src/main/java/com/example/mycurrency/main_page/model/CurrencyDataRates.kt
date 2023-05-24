package com.example.mycurrency.main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyDataRates(
    val aud: Float,
    val bgn: Float,
    val brl: Float,
    val cad: Float,
    val chf: Float,
    val cny: Float,
    val czk: Float,
    val dkk: Float,
    val eur: Float,
    val jpy: Float,
    val rub: Float,
    val usd: Float
):Parcelable
