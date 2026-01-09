package com.example.harshithbackendproject.service;

import com.example.harshithbackendproject.client.GoldBrokerClient;
import com.example.harshithbackendproject.dto.price.CurrentPriceResponse;
import com.example.harshithbackendproject.dto.price.GoldBrokerPriceResponse;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    private final GoldBrokerClient goldBrokerClient;

    public PriceService(GoldBrokerClient goldBrokerClient) {
        this.goldBrokerClient = goldBrokerClient;
    }

    public CurrentPriceResponse getCurrentPrice(String metal, String currency, String unit) {
        GoldBrokerPriceResponse res = goldBrokerClient.fetchSpotPrice(metal, currency, unit);

        return new CurrentPriceResponse(
                res.getMetal() != null ? res.getMetal() : metal,
                res.getCurrency() != null ? res.getCurrency() : currency,
                res.getWeight_unit() != null ? res.getWeight_unit() : unit,
                res.getPrice(),
                res.getTimestamp()
        );
    }
}