package com.example.harshithbackendproject.dto.price;

public class CurrentPriceResponse {
    private String metal;
    private String currency;
    private String unit;
    private double price;
    private String timestamp;

    public CurrentPriceResponse(String metal, String currency, String unit, double price, String timestamp) {
        this.metal = metal;
        this.currency = currency;
        this.unit = unit;
        this.price = price;
        this.timestamp = timestamp;
    }

    public String getMetal() { return metal; }
    public String getCurrency() { return currency; }
    public String getUnit() { return unit; }
    public double getPrice() { return price; }
    public String getTimestamp() { return timestamp; }
}