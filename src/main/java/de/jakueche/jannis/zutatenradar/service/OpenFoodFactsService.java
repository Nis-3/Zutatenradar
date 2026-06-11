package de.jakueche.jannis.zutatenradar.service;

import de.jakueche.jannis.zutatenradar.dto.openfoodfacts.ProductSearchResponse;
import de.jakueche.jannis.zutatenradar.exception.ExternalApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class OpenFoodFactsService {

    private final RestClient restClient;

    public OpenFoodFactsService(RestClient openFoodFactsRestClient) {
        this.restClient = openFoodFactsRestClient;
    }

    public ProductSearchResponse searchProducts(String query) {
        try {
            return restClient.get()
                    .uri("/cgi/search.pl?search_terms={query}&json=true&page_size=5", query)
                    .retrieve()
                    .body(ProductSearchResponse.class);
        } catch (RestClientException ex) {
            throw new ExternalApiException("OpenFoodFacts API nicht erreichbar: " + ex.getMessage(), ex);
        }
    }
}
