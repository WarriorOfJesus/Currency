package com.example.mycurrency.main_page.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyDataInfo(
val currencies : List<Currency>
) : Parcelable
