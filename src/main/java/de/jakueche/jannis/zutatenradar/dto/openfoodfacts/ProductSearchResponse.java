package de.jakueche.jannis.zutatenradar.dto.openfoodfacts;

// TODO: DTO fuer die Antwort der OpenFoodFacts Search-API
//
// Die externe API liefert JSON in IHRER Struktur -- wir mappen nur die Felder die wir brauchen.
// @JsonIgnoreProperties(ignoreUnknown = true) macht die Records robust gegen API-Aenderungen.
//
// Java Record:
//   @JsonIgnoreProperties(ignoreUnknown = true)
//   public record ProductSearchResponse(
//       int count,
//       List<Product> products
//   ) {}
//
// Verschachtelte Records fuer die Produktdaten:
//   @JsonIgnoreProperties(ignoreUnknown = true)
//   public record Product(
//       String product_name,
//       Nutriments nutriments
//   ) {}
//
//   @JsonIgnoreProperties(ignoreUnknown = true)
//   public record Nutriments(
//       double energy_kcal_100g,
//       double proteins_100g,
//       double carbohydrates_100g,
//       double fat_100g
//   ) {}

public class ProductSearchResponse {
}
