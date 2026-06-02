package de.jakueche.jannis.zutatenradar.service;

// TODO: Service fuer die externe OpenFoodFacts-API (@Service)
//
// Bekommt einen RestClient per Constructor Injection (konfiguriert in OpenFoodFactsApiConfig).
//
// Aufgabe: Naehrwertdaten zu einer Zutat von OpenFoodFacts abrufen.
// API-Docs: https://world.openfoodfacts.org/api/v2/
//
// Methoden:
//   - List<ProductInfo> searchProducts(String query) -- Produkte nach Name suchen
//     Ruft z.B. GET https://world.openfoodfacts.org/cgi/search.pl?search_terms=pasta&json=true auf
//     Deserialisiert die JSON-Antwort in eigene DTOs (im dto/openfoodfacts Package)
//
// Fehlerbehandlung:
//   - RestClientException abfangen -> ExternalApiException werfen
//   - onStatus fuer 4xx/5xx Fehler
//
// Spaeter: @Retryable fuer Resilienz bei Netzwerkfehlern

public class OpenFoodFactsService {
}
