package com.example.harshithbackendproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpClientConfig {

    @Bean
    public RestClient goldBrokerRestClient(RestClient.Builder builder) {
        // This creates the bean that your GoldBrokerClient is asking for
        return builder
                .baseUrl("https://api.gold-broker.com") // Replace with actual base URL
                .build();
    }
}