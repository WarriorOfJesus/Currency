package com.example.mycurrency.main_page.model

import com.example.mycurrency.main_page.api.model.*

object CurrencyConverter {
    fun fromNetwork(
        response: DataInfoResponse, ratesResponse: DataRatesResponse
    ): CurrencyDataInfo {
        val currencies = mutableListOf<Currency>()
        var currency = fromNetwork(response.data.usd, ratesResponse.data.usd)
        currencies.add(currency)
        currency = fromNetwork(response.data.bgn, ratesResponse.data.bgn)
        currencies.add(currency)
        currency = fromNetwork(response.data.cny, ratesResponse.data.cny)
        currencies.add(currency)
        currency = fromNetwork(response.data.chf, ratesResponse.data.chf)
        currencies.add(currency)
        currency = fromNetwork(response.data.brl, ratesResponse.data.brl)
        currencies.add(currency)
        currency = fromNetwork(response.data.cad, ratesResponse.data.cad)
        currencies.add(currency)
        currency = fromNetwork(response.data.czk, ratesResponse.data.czk)
        currencies.add(currency)
        currency = fromNetwork(response.data.jpy, ratesResponse.data.jpy)
        currencies.add(currency)
        currency = fromNetwork(response.data.aud, ratesResponse.data.aud)
        currencies.add(currency)
        currency = fromNetwork(response.data.dkk, ratesResponse.data.dkk)
        currencies.add(currency)
        currency = fromNetwork(response.data.eur, ratesResponse.data.eur)
        currencies.add(currency)
        currency = fromNetwork(response.data.rub, ratesResponse.data.rub)
        currencies.add(currency)

        return CurrencyDataInfo(currencies)
    }


    private fun fromNetwork(response: UsdResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }

    private fun fromNetwork(response: BgnResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }


    private fun fromNetwork(response: BrlResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }

    private fun fromNetwork(response: CadResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }

    private fun fromNetwork(response: CnyResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }


    private fun fromNetwork(response: ChfResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }

    private fun fromNetwork(response: CzkResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }

    private fun fromNetwork(response: DkkResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }

    private fun fromNetwork(response: EurResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }


    private fun fromNetwork(response: JpyResponse?, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response?.symbol ?: "",
            name = response?.name ?: "",
            symbolNative = response?.symbolNative ?: "",
            decimalDigits = response?.decimalDigits ?: 0,
            rounding = response?.rounding ?: 0,
            code = response?.code ?: "",
            namePlural = response?.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }


    private fun fromNetwork(response: RubResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }

    private fun fromNetwork(response: AudResponse, ratesResponse: Double?): Currency {
        return Currency(
            symbol = response.symbol ?: "",
            name = response.name ?: "",
            symbolNative = response.symbolNative ?: "",
            decimalDigits = response.decimalDigits ?: 0,
            rounding = response.rounding ?: 0,
            code = response.code ?: "",
            namePlural = response.namePlural ?: "",
            rates = ratesResponse ?: 0.0
        )
    }
}
