package de.jakueche.jannis.zutatenradar.config;

// TODO: Konfiguration des RestClients fuer OpenFoodFacts (@Configuration)
//
// Analog zu NasaApiConfig aus Vorlesung 7.
//
// Liest Werte aus application.properties:
//   @Value("${openfoodfacts.api.base-url}") -> https://world.openfoodfacts.org
//   @Value("${openfoodfacts.api.connect-timeout-ms}") -> 2000
//   @Value("${openfoodfacts.api.read-timeout-ms}") -> 5000
//
// Erstellt einen @Bean RestClient mit:
//   - baseUrl
//   - Timeouts (Connect + Read) via SimpleClientHttpRequestFactory
//   - Default Accept-Header: application/json
//
// OpenFoodFacts braucht KEINEN API-Key -- ist komplett kostenlos und offen.

public class OpenFoodFactsApiConfig {
}
