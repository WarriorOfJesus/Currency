package com.example.mycurrency.main_page.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycurrency.R
import com.example.mycurrency.main_page.model.Currency

class AdapterCurrency(

) : RecyclerView.Adapter<CurrencyViewHolder>() {
    private val data = mutableListOf<Currency>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return CurrencyViewHolder(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val listItem = data[position]
        holder.onBind(listItem)
    }

    fun setData(items: List<Currency>) {
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }
}