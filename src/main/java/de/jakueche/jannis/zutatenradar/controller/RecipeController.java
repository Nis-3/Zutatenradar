package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.dto.RecipeRequest;
import de.jakueche.jannis.zutatenradar.dto.RecipeResponse;
import de.jakueche.jannis.zutatenradar.mapper.RecipeMapper;
import de.jakueche.jannis.zutatenradar.model.Recipe;
import de.jakueche.jannis.zutatenradar.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // GET /api/recipes -- alle Rezepte auflisten
    @GetMapping
    public List<RecipeResponse> getAll() {
        return recipeService.findAll().stream()
                .map(RecipeMapper::toResponse)
                .toList();
    }

    // GET /api/recipes/{id} -- ein bestimmtes Rezept mit Zutaten
    @GetMapping("/{id}")
    public RecipeResponse getById(@PathVariable Long id) {
        return RecipeMapper.toResponse(recipeService.getOrThrow(id));
    }

    // GET /api/recipes/search?name=Carb -- Rezepte nach Name suchen
    @GetMapping("/search")
    public List<RecipeResponse> searchByName(@RequestParam String name) {
        return recipeService.searchByName(name).stream()
                .map(RecipeMapper::toResponse)
                .toList();
    }

    // GET /api/recipes/category/{categoryId} -- Rezepte einer Kategorie
    @GetMapping("/category/{categoryId}")
    public List<RecipeResponse> getByCategory(@PathVariable Long categoryId) {
        return recipeService.findByCategoryId(categoryId).stream()
                .map(RecipeMapper::toResponse)
                .toList();
    }

    // POST /api/recipes -- neues Rezept erstellen
    // @Valid prüft die Bean Validation Annotationen im RecipeRequest
    @PostMapping
    public ResponseEntity<RecipeResponse> create(@Valid @RequestBody RecipeRequest request) {
        Recipe created = recipeService.create(request);
        RecipeResponse response = RecipeMapper.toResponse(created);
        return ResponseEntity
                .created(URI.create("/api/recipes/" + created.getId()))
                .body(response);
    }

    // PUT /api/recipes/{id} -- bestehendes Rezept aktualisieren
    @PutMapping("/{id}")
    public RecipeResponse update(@PathVariable Long id, @Valid @RequestBody RecipeRequest request) {
        return RecipeMapper.toResponse(recipeService.update(id, request));
    }

    // DELETE /api/recipes/{id} -- Rezept löschen
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        recipeService.delete(id);
    }
}
