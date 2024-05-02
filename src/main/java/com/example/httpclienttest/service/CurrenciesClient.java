package com.example.httpclienttest.service;


import com.example.httpclienttest.dto.external.CurrencyRateDto;
import com.example.httpclienttest.dto.external.CurrencyResponseDataDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class CurrenciesClient {
    private static final String  BASE_URL =
            "https://api.currencyapi.com/v3/latest?apikey=%s&currencies=%s&base_currency=%s";
    private static final String  TOKEN = "cur_live_VtUhcld7K9afgGJwxJ3WHaxeFVC4wdZBo8QjvrDy";
    private static final String  CURRENCIES_SEPARATOR = "%2C";


    @Value("${mate.academy.currencies.api.key}")
    private String apiKey;

    private final ObjectMapper objectMapper;


    public List<CurrencyRateDto> getCurrenciesRates(String baseCur, List<String > currencies)  {
        HttpClient httpClient = HttpClient.newHttpClient();
        String url = BASE_URL.formatted(
                apiKey,
                String.join(CURRENCIES_SEPARATOR, currencies),
                baseCur);

        HttpRequest httpRequest =HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                //.header("AUTHORIZATION", "Basic Ym9iOjEyMzQ=")
                .build();

        try {
            HttpResponse<String> response = httpClient
                    .send(httpRequest, HttpResponse.BodyHandlers.ofString());
            CurrencyResponseDataDto dataDto = objectMapper
                    .readValue(response.body(), CurrencyResponseDataDto.class);
            System.out.println(dataDto);
            return dataDto.getData().values().stream().toList();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
