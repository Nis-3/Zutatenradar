package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.dto.openfoodfacts.ProductSearchResponse;
import de.jakueche.jannis.zutatenradar.dto.openfoodfacts.ProductSearchResponse.Nutriments;
import de.jakueche.jannis.zutatenradar.dto.openfoodfacts.ProductSearchResponse.Product;
import de.jakueche.jannis.zutatenradar.service.OpenFoodFactsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Testet den NutritionController, Api Aufruf wird Simuliert
@WebMvcTest(NutritionController.class)
class NutritionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private OpenFoodFactsService openFoodFactsService;

    // GET /api/nutrition/search?query=spaghetti soll erwartete Daten zurückgeben
    @Test
    void searchProducts_returnsNutritionData() throws Exception {
        Nutriments nutriments = new Nutriments(350, 13, 71, 2);
        Product product = new Product("Spaghetti N° 5", nutriments);
        ProductSearchResponse response = new ProductSearchResponse(1, List.of(product));

        when(openFoodFactsService.searchProducts("spaghetti")).thenReturn(response);

        mockMvc.perform(get("/api/nutrition/search").param("query", "spaghetti"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(1))
                .andExpect(jsonPath("$.products[0].product_name").value("Spaghetti N° 5"))
                .andExpect(jsonPath("$.products[0].nutriments.energy-kcal_100g").value(350));
    }
}
