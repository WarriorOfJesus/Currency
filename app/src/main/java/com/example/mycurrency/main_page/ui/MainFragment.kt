package com.example.mycurrency.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycurrency.common.mvvm.BaseFragment
import com.example.mycurrency.databinding.FragmentCurrencyTransferBinding
import com.example.mycurrency.databinding.FragmentMainBinding
import com.example.mycurrency.main_page.model.Currency
import com.example.mycurrency.main_page.model.CurrencyDataInfo
import com.example.mycurrency.main_page.ui.adapter.AdapterCurrency
import com.example.mycurrency.utils.Constants
import com.example.mycurrency.utils.replace
import org.koin.android.ext.android.inject
import timber.log.Timber


class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainPageViewModel by inject()

    private val adapter by lazy { AdapterCurrency() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.doOnAttach {
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
            recyclerView.doOnDetach {
                recyclerView.layoutManager = null
            }
            buttonToCurrencyTransfer.setOnClickListener { replace(CurrencyTransferFragment()) }

        }

        viewModel.getCurrency(Constants.API_KEY, Constants.CURRENCIES, "USD")


        observe(viewModel.currencyFlow) {
            showData(it.currencies)
        }

    }

    private fun showData(data: List<Currency>) {
        adapter.setData(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.finish()
    }
}