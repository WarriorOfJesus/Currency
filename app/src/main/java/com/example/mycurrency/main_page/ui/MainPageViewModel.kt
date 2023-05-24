package com.example.mycurrency.main_page.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycurrency.main_page.interactor.CurrencyInteractor
import com.example.mycurrency.main_page.model.CurrencyDataInfo
import com.example.mycurrency.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPageViewModel(
    private val interactor: CurrencyInteractor
) : ViewModel() {
    val coroutineScope = CoroutineScope(Dispatchers.Main)
     private val _currencyFlow = MutableSharedFlow<CurrencyDataInfo>()
    val currencyFlow: SharedFlow<CurrencyDataInfo>
        get() = _currencyFlow.asSharedFlow()



    fun getCurrency(
        apikey: String,
        currencies: String,
        baseCurrency: String
    ) {
        viewModelScope.launch {
            try {
                 val data = interactor.getCurrencyData(
                    Constants.API_KEY,
                    currencies = Constants.CURRENCIES,
                    baseCurrency = baseCurrency
                )

                _currencyFlow.emit(data)
                Timber.i("--->> viewModel :$data")
            } catch (t: Throwable) {
                Timber.e("error ---->${t.message}")
            }
        }
    }

//    fun updateCurrency(firstNumber : Float, ){
//        val sum =
//    }

}