package com.example.httpclienttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HttpClientTestApplication {
//http://localhost:8080/curr/convert?amount=100&baseCurrency=UAH&currencies=EUR,USD
    public static void main(String[] args) {
        SpringApplication.run(HttpClientTestApplication.class, args);
    }

}
