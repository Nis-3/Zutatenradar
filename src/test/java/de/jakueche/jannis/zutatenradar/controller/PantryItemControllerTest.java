package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.model.Category;
import de.jakueche.jannis.zutatenradar.model.Ingredient;
import de.jakueche.jannis.zutatenradar.model.Recipe;
import de.jakueche.jannis.zutatenradar.service.PantryItemService;
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


@WebMvcTest(PantryItemController.class)
class PantryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PantryItemService pantryItemService;


    @Test
    void getMatchingRecipes_returnsMatchingRecipes() throws Exception {
        Category kategorie = new Category(1L, "Hauptgericht", null);
        Recipe carbonara = new Recipe(1L, "Spaghetti Carbonara", "Lecker", null, kategorie, List.of());
        Ingredient zutat = new Ingredient(1L, "Spaghetti", "500g", carbonara);
        carbonara = new Recipe(1L, "Spaghetti Carbonara", "Lecker", null, kategorie, List.of(zutat));

        when(pantryItemService.findMatchingRecipes()).thenReturn(List.of(carbonara));

        mockMvc.perform(get("/api/pantry/matching-recipes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Spaghetti Carbonara"));
    }
}
