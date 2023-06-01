package com.example.mycurrency.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.example.mycurrency.R
import com.example.mycurrency.common.mvvm.BaseFragment
import com.example.mycurrency.databinding.FragmentCurrencyTransferBinding
import com.example.mycurrency.main_page.model.CurrencyEnum
import org.koin.android.ext.android.inject

class CurrencyTransferFragment : BaseFragment(R.layout.fragment_currency_transfer) {
    lateinit var binding: FragmentCurrencyTransferBinding


    val fromCurrencyAdapter: ArrayAdapter<CurrencyEnum> by lazy {
        ArrayAdapter(requireContext(), R.layout.item_view_currency, CurrencyEnum.values())
    }
    private val toCurrencyAdapter: ArrayAdapter<CurrencyEnum> by lazy {
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
        }

        setAdaptersListeners()
        setCurrencyAmountEditTextListener()
        setObservers()

    }

    private fun setAdaptersListeners() {

        binding.fromCurrency.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val currency = fromCurrencyAdapter.getItem(position)
                    Toast.makeText(requireContext(), currency?.name, Toast.LENGTH_SHORT).show()
                    viewModel.setBaseCurrency(currency)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

        binding.toCurrency.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val currency = fromCurrencyAdapter.getItem(position)
                    Toast.makeText(requireContext(), currency?.name, Toast.LENGTH_SHORT).show()
                    viewModel.setSecondaryCurrency(currency)

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }

    }

    private fun setCurrencyAmountEditTextListener() {
        binding.editTextCurrencyAmount.doAfterTextChanged { text ->
            if (text.isNullOrEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "please enter the rate of currency",
                    Toast.LENGTH_LONG
                ).show()
            }
            viewModel.addLeftCurrency(text.toString())
            viewModel.updateCurrency(text.toString())
        }
    }

    private fun setObservers() {
        with(binding) {

            observe(viewModel.secondarySum) { secondSum ->
                textNumberCurrency.text = secondSum.toString()
            }
            observe(viewModel.isLoading) {
                progressView.isVisible = it
            }
        }
    }
}


