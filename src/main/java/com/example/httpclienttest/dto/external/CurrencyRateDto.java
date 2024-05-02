package com.example.httpclienttest.dto.external;

import java.math.BigDecimal;

public record CurrencyRateDto(String code, BigDecimal value) {
}
