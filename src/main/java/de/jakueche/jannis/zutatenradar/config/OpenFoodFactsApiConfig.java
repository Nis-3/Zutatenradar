package de.jakueche.jannis.zutatenradar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.time.Duration;

// Konfiguration des RestClients für die OpenFoodFacts-API
// Liest die Werte aus application.properties (@Value)
@Configuration
public class OpenFoodFactsApiConfig {

    @Value("${openfoodfacts.api.base-url}")
    private String baseUrl;

    @Value("${openfoodfacts.api.connect-timeout-ms}")
    private int connectTimeout;

    @Value("${openfoodfacts.api.read-timeout-ms}")
    private int readTimeout;

    // Erstellt einen RestClient-Bean mit Base-URL, Timeouts und JSON-Header
    @Bean
    RestClient openFoodFactsRestClient() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(Duration.ofMillis(connectTimeout));
        factory.setReadTimeout(Duration.ofMillis(readTimeout));

        return RestClient.builder()
                .baseUrl(baseUrl)
                .requestFactory(factory)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
