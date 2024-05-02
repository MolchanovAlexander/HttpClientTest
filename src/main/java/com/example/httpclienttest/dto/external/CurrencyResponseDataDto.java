package com.example.httpclienttest.dto.external;

import java.util.Map;
import lombok.Data;

@Data
public class CurrencyResponseDataDto {
    private CurrencyMetaDataDto meta;
    private Map<String, CurrencyRateDto> data;
}
