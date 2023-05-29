package com.example.mycurrency.common.di

import com.example.currency.common.di.InjectionModule
import com.example.mycurrency.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule : InjectionModule {
    override fun onCreate() =
        module {
            single {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                val client = OkHttpClient
                    .Builder()
                    .addInterceptor(interceptor)
                    .build()

                Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .build()
            }
        }

}
