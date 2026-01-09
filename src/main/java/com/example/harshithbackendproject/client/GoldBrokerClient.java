package com.example.harshithbackendproject.client;

import com.example.harshithbackendproject.dto.price.GoldBrokerPriceResponse;
import com.example.harshithbackendproject.exception.ApiException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GoldBrokerClient {

    private final RestClient restClient;

    public GoldBrokerClient(RestClient goldBrokerRestClient) {
        this.restClient = goldBrokerRestClient;
    }

    public GoldBrokerPriceResponse fetchSpotPrice(String metal, String currency, String unit) {
        GoldBrokerPriceResponse body = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/spot-price")
                        .queryParam("metal", metal)
                        .queryParam("currency", currency)
                        .queryParam("weight_unit", unit)
                        .build()
                )
                .retrieve()
                .onStatus(HttpStatusCode::isError, (req, res) -> {
                    throw new ApiException(res.getStatusCode().value(),
                            "GoldBroker API failed with status " + res.getStatusCode().value());
                })
                .body(GoldBrokerPriceResponse.class);

        if (body == null) {
            throw new ApiException(502, "GoldBroker API returned empty response");
        }
        if (body.getPrice() == null) {
            throw new ApiException(502, "GoldBroker API response missing price field");
        }
        return body;
    }
}