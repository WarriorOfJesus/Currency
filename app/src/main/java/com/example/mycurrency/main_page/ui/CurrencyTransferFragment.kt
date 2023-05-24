package com.example.mycurrency.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mycurrency.R
import com.example.mycurrency.databinding.FragmentCurrencyTransferBinding
import com.example.mycurrency.main_page.model.CurrencyEnum
import org.koin.android.ext.android.inject

class CurrencyTransferFragment : Fragment() {
    lateinit var binding: FragmentCurrencyTransferBinding

    val fromCurrencyAdapter: ArrayAdapter<CurrencyEnum> by lazy {
        ArrayAdapter(requireContext(), R.layout.item_view_currency, CurrencyEnum.values())
    }
    val toCurrencyAdapter: ArrayAdapter<CurrencyEnum> by lazy {
        ArrayAdapter(requireContext(), R.layout.item_view_currency, CurrencyEnum.values())
    }

    private val viewModel: MainPageViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyTransferBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            fromCurrency.adapter = fromCurrencyAdapter
            toCurrency.adapter = toCurrencyAdapter
            toCurrency.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val currency = fromCurrencyAdapter.getItem(position)
                        Toast.makeText(requireContext(), currency?.name, Toast.LENGTH_SHORT).show()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }


        }
    }
}
