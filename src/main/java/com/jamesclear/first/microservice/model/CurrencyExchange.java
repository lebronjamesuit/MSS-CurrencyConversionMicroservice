package com.jamesclear.first.microservice.model;

import lombok.Data;

@Data
public class CurrencyExchange {
    private int id;
    private String from;
    private String to;
    private double conversionMultiple;
    private String environment;
}
