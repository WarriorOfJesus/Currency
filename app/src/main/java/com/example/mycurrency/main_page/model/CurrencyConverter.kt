package com.example.mycurrency.main_page.model

import com.example.mycurrency.main_page.api.model.*

object CurrencyConverter {
    fun fromNetwork(
        response: DataInfoResponse,
        ratesResponse: DataRatesResponse
    ): CurrencyDataInfo {
        val currencies = mutableListOf<Currency>()
        ratesResponse.data.bgn?.let { fromNetwork(response.data.usd, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.bgn?.let { fromNetwork(response.data.bgn, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.cny?.let { fromNetwork(response.data.cny, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.chf?.let { fromNetwork(response.data.chf, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.brl?.let { fromNetwork(response.data.brl, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.cad?.let { fromNetwork(response.data.cad, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.czk?.let { fromNetwork(response.data.czk, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.jpy?.let { fromNetwork(response.data.jpy, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.aud?.let { fromNetwork(response.data.aud, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.dkk?.let { fromNetwork(response.data.dkk, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.eur?.let { fromNetwork(response.data.eur, it) }
            ?.let { currencies.add(it) }
        ratesResponse.data.rub?.let { fromNetwork(response.data.rub, it) }
            ?.let { currencies.add(it) }
        return CurrencyDataInfo(currencies)
    }

    private fun fromNetwork(response: UsdResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }

    private fun fromNetwork(response: BgnResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }


    private fun fromNetwork(response: BrlResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }

    private fun fromNetwork(response: CadResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }

    private fun fromNetwork(response: CnyResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }


    private fun fromNetwork(response: ChfResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }

    private fun fromNetwork(response: CzkResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }

    private fun fromNetwork(response: DkkResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }

    private fun fromNetwork(response: EurResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }


    private fun fromNetwork(response: JpyResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }


    private fun fromNetwork(response: RubResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }

    private fun fromNetwork(response: AudResponse, ratesResponse: Double): Currency {
        return Currency(
            symbol = response.symbol,
            name = response.name,
            symbolNative = response.symbolNative,
            decimalDigits = response.decimalDigits,
            rounding = response.rounding,
            code = response.code,
            namePlural = response.namePlural,
            rates = ratesResponse
        )
    }


}
