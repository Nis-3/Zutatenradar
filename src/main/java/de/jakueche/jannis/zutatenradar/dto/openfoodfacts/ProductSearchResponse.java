package de.jakueche.jannis.zutatenradar.dto.openfoodfacts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// DTO für die Antwort der OpenFoodFacts API
// @JsonIgnoreProperties(ignoreUnknown = true) ignoriert alle JSON-Felder die wir nicht brauchen
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductSearchResponse(
        int count,                  // Anzahl der gefundenen Produkte
        List<Product> products      // Liste der Produkte
) {

    // Ein einzelnes Produkt aus der API-Antwort
    // @JsonProperty mapped den JSON-Feldnamen auf den Java-Feldnamen
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Product(
            @JsonProperty("product_name") String productName,
            Nutriments nutriments
    ) {}

    // Nährwertdaten eines Produkts pro 100g
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Nutriments(
            @JsonProperty("energy-kcal_100g") double energyKcal100g,
            @JsonProperty("proteins_100g") double proteins100g,
            @JsonProperty("carbohydrates_100g") double carbohydrates100g,
            @JsonProperty("fat_100g") double fat100g
    ) {}
}
