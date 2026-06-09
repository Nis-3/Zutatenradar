package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.dto.IngredientRequest;
import de.jakueche.jannis.zutatenradar.dto.IngredientResponse;
import de.jakueche.jannis.zutatenradar.mapper.IngredientMapper;
import de.jakueche.jannis.zutatenradar.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/recipes/{recipeId}/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    // GET /api/recipes/{recipeId}/ingredients -- alle Zutaten eines Rezepts
    @GetMapping
    public List<IngredientResponse> getByRecipe(@PathVariable Long recipeId) {
        return ingredientService.findByRecipeId(recipeId).stream()
                .map(IngredientMapper::toResponse)
                .toList();
    }

    // POST /api/recipes/{recipeId}/ingredients -- Zutat hinzufügen
    @PostMapping
    public ResponseEntity<IngredientResponse> create(
            @PathVariable Long recipeId,
            @Valid @RequestBody IngredientRequest request) {
        var created = ingredientService.create(recipeId, request);
        IngredientResponse response = IngredientMapper.toResponse(created);
        return ResponseEntity
                .created(URI.create("/api/recipes/" + recipeId + "/ingredients/" + created.getId()))
                .body(response);
    }

    // DELETE /api/recipes/{recipeId}/ingredients/{id} -- Zutat entfernen
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long recipeId, @PathVariable Long id) {
        ingredientService.delete(id);
    }
}
