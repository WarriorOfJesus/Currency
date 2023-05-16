package com.example.mycurrency.main_page.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.example.mycurrency.R
import com.example.mycurrency.common.mvvm.BaseFragment
import com.example.mycurrency.databinding.FragmentMainBinding
import com.example.mycurrency.utils.Constants
import org.koin.android.ext.android.inject
import timber.log.Timber


class MainFragment : BaseFragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel : MainPageViewModel by inject()
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
        observe(viewModel.currencyFlow){
            Timber.d("--->> mainFragment : $it")
        }
        with(binding) {
            editText.doAfterTextChanged {
                val baseCurrency = editText.text.toString()

            }
        }
        viewModel.getCurrency(Constants.API_KEY, Constants.CURRENCIES, "RUB")

    }
}