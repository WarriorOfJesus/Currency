package com.example.mycurrency.main_page.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycurrency.main_page.interactor.CurrencyInteractor
import com.example.mycurrency.main_page.model.CurrencyDataInfo
import com.example.mycurrency.main_page.model.CurrencyEnum
import com.example.mycurrency.utils.Constants
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class MainPageViewModel(
    private val interactor: CurrencyInteractor
) : ViewModel() {

    private var currencyRate: String? = "0.0"

    private val _currencyFlow = MutableStateFlow<CurrencyDataInfo?>(null)
    val currencyFlow = _currencyFlow.asStateFlow()


    private val _secondarySum = MutableStateFlow(0.0)
    val secondarySum = _secondarySum.asStateFlow()

    private val _baseCurrency = MutableStateFlow(CurrencyEnum.AUD)

    private val _secondaryCurrency = MutableStateFlow(CurrencyEnum.AUD)

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading.asStateFlow()

    private val _leftCurrency = MutableStateFlow(0)
    private val leftRate = _leftCurrency.asStateFlow()


    fun getCurrency(
        baseCurrency: String
    ) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val data = interactor.getCurrencyData(
                    Constants.API_KEY,
                    currencies = Constants.CURRENCIES,
                    baseCurrency = baseCurrency
                )
                _currencyFlow.emit(data)
                updateRate(_secondaryCurrency.value)

                Timber.i("--->> viewModel :$data")
            } catch (e: CancellationException) {
                Timber.e("error ---->${e.message}")
            } catch (t: Throwable) {
                Timber.e("error ---->${t.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun updateRate(currency: CurrencyEnum?) {
        currencyRate = _currencyFlow.value?.currencies?.find {
            it.code == currency?.name
        }?.rates
        val rate = currencyRate?.toDouble() ?: 0.0
        val leftCurrency = leftRate.value.toDouble()
        _secondarySum.value = leftCurrency * rate

    }

    fun setBaseCurrency(currency: CurrencyEnum?) {
        if (currency == null) return
        _baseCurrency.value = currency
        getCurrency(currency.name)
    }

    fun setSecondaryCurrency(currency: CurrencyEnum?) {
        if (currency == null) return
        _secondaryCurrency.value = currency
        updateRate(currency)
    }

    fun updateCurrency(text: String?) {
        if (text.isNullOrEmpty()) _secondarySum.value = 0.0
        if (text == null || currencyRate == null) return
        val number = text.toDoubleOrNull() ?: return
        val rate = currencyRate?.toDouble() ?: return
        val sum = number * rate
        _secondarySum.value = sum
    }

    fun addLeftCurrency(text: String?) {
        if (text == null) return
        val leftCurrency = text.toIntOrNull() ?: 0
        _leftCurrency.value = leftCurrency
    }

}
