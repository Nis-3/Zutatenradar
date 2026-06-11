package de.jakueche.jannis.zutatenradar.dto.openfoodfacts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductSearchResponse(
        int count,
        List<Product> products
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Product(
            @JsonProperty("product_name") String productName,
            Nutriments nutriments
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Nutriments(
            @JsonProperty("energy-kcal_100g") double energyKcal100g,
            @JsonProperty("proteins_100g") double proteins100g,
            @JsonProperty("carbohydrates_100g") double carbohydrates100g,
            @JsonProperty("fat_100g") double fat100g
    ) {}
}
