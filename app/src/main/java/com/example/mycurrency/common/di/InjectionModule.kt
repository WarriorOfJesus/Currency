package com.example.currency.common.di

import org.koin.core.module.Module

interface InjectionModule {
    fun onCreate() :  Module
}