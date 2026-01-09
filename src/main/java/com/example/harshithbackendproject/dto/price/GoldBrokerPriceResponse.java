package com.example.harshithbackendproject.dto.price;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoldBrokerPriceResponse {
    private String metal;
    private String currency;
    private String weight_unit;
    private Double price;
    private String timestamp;

    public String getMetal() { return metal; }
    public String getCurrency() { return currency; }
    public String getWeight_unit() { return weight_unit; }
    public Double getPrice() { return price; }
    public String getTimestamp() { return timestamp; }

    public void setMetal(String metal) { this.metal = metal; }
    public void setCurrency(String currency) { this.currency = currency; }
    public void setWeight_unit(String weight_unit) { this.weight_unit = weight_unit; }
    public void setPrice(Double price) { this.price = price; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}