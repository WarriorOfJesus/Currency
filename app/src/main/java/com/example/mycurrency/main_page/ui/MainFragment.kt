package com.example.mycurrency.main_page.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycurrency.R
import com.example.mycurrency.common.mvvm.BaseFragment
import com.example.mycurrency.databinding.FragmentMainBinding
import com.example.mycurrency.main_page.model.Currency
import com.example.mycurrency.main_page.model.CurrencyEnum
import com.example.mycurrency.main_page.ui.adapter.AdapterCurrency
import com.example.mycurrency.utils.extensions.replace
import com.example.mycurrency.utils.extensions.viewbinding.viewBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val  binding: FragmentMainBinding by viewBinding()
    private val viewModel: MainPageViewModel by viewModel()

    private val adapter by lazy { AdapterCurrency() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        onAttachRecycler()

        setObserves()
        with(binding) {
            buttonToCurrencyTransfer.setOnClickListener { replace(CurrencyTransferFragment()) }
            buttonLogout.setOnClickListener {
                Firebase.auth.signOut()
                replace(LoginFragment())
            }
        }
        viewModel.getCurrency(CurrencyEnum.USD.name)
    }


    private fun onDetachRecycler() {
        with(binding) {
            recyclerView.doOnDetach {
                recyclerView.layoutManager = null
            }
        }
    }

    private fun onAttachRecycler() {
        with(binding) {
            recyclerView.doOnAttach {
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    private fun setObserves() {
        observeNullable(viewModel.currencyFlow) {
            it?.currencies?.let { it1 -> showData(it1) }
        }
        observe(viewModel.isLoading) {
            binding.progressBarRecycler.isVisible = it
        }
    }

    private fun showData(data: List<Currency>) {
        adapter.setData(data)
    }

    override fun onDestroy() {
        super.onDestroy()
        onDetachRecycler()
        activity?.finish()
    }
}
