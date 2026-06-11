package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.dto.openfoodfacts.ProductSearchResponse;
import de.jakueche.jannis.zutatenradar.service.OpenFoodFactsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionController {

    private final OpenFoodFactsService openFoodFactsService;

    public NutritionController(OpenFoodFactsService openFoodFactsService) {
        this.openFoodFactsService = openFoodFactsService;
    }

    @GetMapping("/search")
    public ProductSearchResponse search(@RequestParam String query) {
        return openFoodFactsService.searchProducts(query);
    }
}
