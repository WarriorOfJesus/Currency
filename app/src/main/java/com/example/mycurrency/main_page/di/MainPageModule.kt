package com.example.mycurrency.main_page.di

import com.example.currency.common.di.InjectionModule
import com.example.mycurrency.main_page.repository.CurrencyRepository
import com.example.mycurrency.main_page.interactor.CurrencyInteractor
import com.example.mycurrency.main_page.repository.CurrencyRemoteRepository
import com.example.mycurrency.main_page.ui.MainPageViewModel
import com.example.mycurrency.main_page.api.CurrencyApi
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object MainPageModule : InjectionModule {
    override fun onCreate() = module {
        single { get<Retrofit>().create(CurrencyApi::class.java) }
        single<CurrencyRepository> { CurrencyRemoteRepository(get()) }
        singleOf(::CurrencyRemoteRepository) bind CurrencyRepository::class
        factoryOf(::CurrencyInteractor)
        viewModelOf(::MainPageViewModel)
    }
}