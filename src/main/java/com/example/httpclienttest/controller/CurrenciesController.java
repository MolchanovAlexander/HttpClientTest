package com.example.httpclienttest.controller;


import com.example.httpclienttest.dto.internal.CurrencyConversionDto;
import com.example.httpclienttest.service.RatesCalculatorService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/curr")
public class CurrenciesController {
    private final RatesCalculatorService ratesCalculatorService;

    @GetMapping("/convert")
    public List<CurrencyConversionDto> getConversions(@RequestParam(defaultValue = "100") BigDecimal amount,
                                                      @RequestParam(defaultValue = "EUR") String baseCurrency,
                                                      @RequestParam(defaultValue = "USD") List<String> currencies
    ) {
        return ratesCalculatorService.getConversions(amount, baseCurrency, currencies);
    }
}
