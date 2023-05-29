package com.example.mycurrency.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.mycurrency.databinding.ItemCurrencyBinding
import com.example.mycurrency.main_page.model.Currency

class CurrencyViewHolder(
    private val binding: ItemCurrencyBinding
) : RecyclerView.ViewHolder(binding.root) {

    constructor(
        parent: ViewGroup
    ):this(
        ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    fun onBind(item: Currency) {
        with(binding) {
            nameOfCurrency.text = item.code
            symbolOfCurrency.text = item.symbol
            rateOfCurrency.text = item.rates
        }
    }
}