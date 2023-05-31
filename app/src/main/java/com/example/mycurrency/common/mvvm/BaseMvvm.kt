package com.example.mycurrency.common.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

open class BaseMvvm : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading.asStateFlow()

    protected fun handle(onDataHandle: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
//                onDataHandle.invoke() одно и тоже с тем что снизу
                onDataHandle()
            } catch (e: CancellationException) {
                Timber.e("error ---->${e.message}")//сделать flow Для ошибок
            } catch (t: Throwable) {
                Timber.e("error ---->${t.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}