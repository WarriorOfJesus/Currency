package com.example.mycurrency.main_page.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnAttach
import androidx.core.view.doOnDetach
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycurrency.common.mvvm.BaseFragment
import com.example.mycurrency.databinding.FragmentMainBinding
import com.example.mycurrency.main_page.model.Currency
import com.example.mycurrency.main_page.model.CurrencyEnum
import com.example.mycurrency.main_page.ui.adapter.AdapterCurrency
import com.example.mycurrency.utils.replace
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.android.inject


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
        binding.recyclerView.adapter = adapter
        onAttachRecycler()
        onDetachRecycler()
        setObserves()
        clickButtons()
        viewModel.getCurrency(CurrencyEnum.USD.name)
    }

    private fun clickButtons() {
        with(binding) {
            buttonToCurrencyTransfer.setOnClickListener { replace(CurrencyTransferFragment()) }
            buttonLogout.setOnClickListener {
                Firebase.auth.signOut()
                replace(LoginFragment())
            }
        }
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
        activity?.finish()
    }
}
