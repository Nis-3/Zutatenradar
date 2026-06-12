package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.exception.RecipeNotFoundException;
import de.jakueche.jannis.zutatenradar.model.Category;
import de.jakueche.jannis.zutatenradar.model.Ingredient;
import de.jakueche.jannis.zutatenradar.model.Recipe;
import de.jakueche.jannis.zutatenradar.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Testet nur den RecipeController mit simulierten Aufruf
@WebMvcTest(RecipeController.class)
class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RecipeService recipeService; // Test Service mit festen Antworten

    // Erstellt ein Test Rezept
    private Recipe createTestRecipe(Long id, String name, String categoryName) {
        Category category = new Category(1L, categoryName, null);
        Recipe recipe = new Recipe(id, name, "Beschreibung", null, category, List.of());
        Ingredient zutat = new Ingredient(1L, "Spaghetti", "500g", recipe);
        recipe = new Recipe(id, name, "Beschreibung", null, category, List.of(zutat));
        return recipe;
    }

    // GET /api/recipes gib alle Test Rezepte zurück und vergleiche
    @Test
    void getAllRecipes_returnsListOfRecipes() throws Exception {
        Recipe r1 = createTestRecipe(1L, "Spaghetti Carbonara", "Hauptgericht");
        Recipe r2 = createTestRecipe(2L, "Tomatensuppe", "Suppe");
        when(recipeService.findAll()).thenReturn(List.of(r1, r2));

        mockMvc.perform(get("/api/recipes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Spaghetti Carbonara"))
                .andExpect(jsonPath("$[1].name").value("Tomatensuppe"));
    }

    // POST /api/recipes prüfen, ob erstelltes Rezept existiert und status code 201 zurückgibt
    @Test
    void createRecipe_withValidData_returns201() throws Exception {
        Recipe created = createTestRecipe(1L, "Neues Rezept", "Hauptgericht");
        when(recipeService.create(any())).thenReturn(created);

        String requestJson = """
                {
                    "name": "Neues Rezept",
                    "description": "Leckeres Gericht",
                    "categoryId": 1
                }
                """;

        mockMvc.perform(post("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Neues Rezept"))
                .andExpect(jsonPath("$.categoryName").value("Hauptgericht"));
    }

    // POST /api/recipes Rezept ohne Namen erstellen, erwartet Satuscode 400
    @Test
    void createRecipe_withEmptyName_returns400() throws Exception {
        String requestJson = """
                {
                    "name": "",
                    "description": "Beschreibung",
                    "categoryId": 1
                }
                """;

        mockMvc.perform(post("/api/recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isBadRequest());
    }

    // GET /api/recipes/999 suchen nach Rezept mit ID 999 erwartet Satuscode 404
    @Test
    void getById_withUnknownId_returns404() throws Exception {
        when(recipeService.getOrThrow(999L)).thenThrow(new RecipeNotFoundException(999L));

        mockMvc.perform(get("/api/recipes/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.title").value("Nicht gefunden"))
                .andExpect(jsonPath("$.detail").value("Rezept mit ID 999 nicht gefunden"));
    }
}
