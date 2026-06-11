package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.dto.openfoodfacts.ProductSearchResponse;
import de.jakueche.jannis.zutatenradar.service.OpenFoodFactsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// REST-Controller für die externe API-Anbindung
// Das Frontend spricht nie direkt mit OpenFoodFacts, nur mit diesem Endpoint
@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    private final OpenFoodFactsService openFoodFactsService;

    public NutritionController(OpenFoodFactsService openFoodFactsService) {
        this.openFoodFactsService = openFoodFactsService;
    }

    // Nährwertdaten zu einem Produkt suchen
    @GetMapping("/search")
    public ProductSearchResponse search(@RequestParam String query) {
        return openFoodFactsService.searchProducts(query);
    }
}
