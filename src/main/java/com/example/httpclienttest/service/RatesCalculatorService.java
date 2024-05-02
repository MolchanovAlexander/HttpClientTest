package com.example.httpclienttest.service;

import com.example.httpclienttest.dto.external.CurrencyRateDto;
import com.example.httpclienttest.dto.internal.CurrencyConversionDto;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RatesCalculatorService {
    private final CurrenciesClient client;

    public RatesCalculatorService(CurrenciesClient client) {
        this.client = client;
    }

    public List<CurrencyConversionDto> getConversions(BigDecimal amount, String baseCur, List<String> currencies) {
        List<CurrencyRateDto> currenciesRates = client.getCurrenciesRates(baseCur, currencies);
        return currenciesRates.stream()
                .map(rate -> new CurrencyConversionDto(
                        baseCur,
                        rate.code(),
                        amount,
                        rate.value(),
                        rate.value().multiply(amount)
                ))
                .toList();
    }
}
