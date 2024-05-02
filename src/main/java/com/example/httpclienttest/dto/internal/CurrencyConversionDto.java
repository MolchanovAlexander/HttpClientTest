package com.example.httpclienttest.dto.internal;

import java.math.BigDecimal;

public record CurrencyConversionDto(
        String baseCurrency,
        String requestedCurrency,
        BigDecimal requestedAmount,
        BigDecimal rate,
        BigDecimal calculatedAmount
) {
}
