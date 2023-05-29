package com.example.mycurrency.main_page.model

import com.example.mycurrency.main_page.api.model.*

object CurrencyConverter {
    fun fromNetwork(
        response: DataInfoResponse,
        ratesResponse: DataRatesResponse
    ): CurrencyDataInfo {
        val currencies = mutableListOf<Currency>()
        ratesResponse.data.usd?.let {
            fromNetwork(response.data.usd, it.toString())
        }
            ?.let { currencies.add(it) }
        ratesResponse.data.bgn?.let { fromNetwork(response.data.bgn, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.cny?.let { fromNetwork(response.data.cny, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.chf?.let { fromNetwork(response.data.chf, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.brl?.let { fromNetwork(response.data.brl, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.cad?.let { fromNetwork(response.data.cad, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.czk?.let { fromNetwork(response.data.czk, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.jpy?.let { fromNetwork(response.data.jpy, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.aud?.let { fromNetwork(response.data.aud, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.dkk?.let { fromNetwork(response.data.dkk, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.eur?.let { fromNetwork(response.data.eur, it.toString()) }
            ?.let { currencies.add(it) }
        ratesResponse.data.rub?.let { fromNetwork(response.data.rub, it.toString()) }
            ?.let { currencies.add(it) }
        return CurrencyDataInfo(currencies)
    }

    private fun fromNetwork(response: UsdResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }

    private fun fromNetwork(response: BgnResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }


    private fun fromNetwork(response: BrlResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }

    private fun fromNetwork(response: CadResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }

    private fun fromNetwork(response: CnyResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }


    private fun fromNetwork(response: ChfResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }

    private fun fromNetwork(response: CzkResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }

    private fun fromNetwork(response: DkkResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }

    private fun fromNetwork(response: EurResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }


    private fun fromNetwork(response: JpyResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }


    private fun fromNetwork(response: RubResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }

    private fun fromNetwork(response: AudResponse, ratesResponse: String): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: ""
        )
    }
}
