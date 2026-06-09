package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.dto.PantryItemRequest;
import de.jakueche.jannis.zutatenradar.dto.PantryItemResponse;
import de.jakueche.jannis.zutatenradar.dto.RecipeResponse;
import de.jakueche.jannis.zutatenradar.mapper.PantryItemMapper;
import de.jakueche.jannis.zutatenradar.mapper.RecipeMapper;
import de.jakueche.jannis.zutatenradar.service.PantryItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pantry")
public class PantryItemController {

    private final PantryItemService pantryItemService;

    public PantryItemController(PantryItemService pantryItemService) {
        this.pantryItemService = pantryItemService;
    }

    // GET /api/pantry -- alle deine Vorräte
    @GetMapping
    public List<PantryItemResponse> getAll() {
        return pantryItemService.findAll().stream()
                .map(PantryItemMapper::toResponse)
                .toList();
    }

    // POST /api/pantry -- "Ich habe Spaghetti"
    @PostMapping
    public ResponseEntity<PantryItemResponse> create(@Valid @RequestBody PantryItemRequest request) {
        var created = pantryItemService.create(request);
        PantryItemResponse response = PantryItemMapper.toResponse(created);
        return ResponseEntity
                .created(URI.create("/api/pantry/" + created.getId()))
                .body(response);
    }

    // PUT /api/pantry/{id} -- Menge ändern
    @PutMapping("/{id}")
    public PantryItemResponse update(@PathVariable Long id, @Valid @RequestBody PantryItemRequest request) {
        return PantryItemMapper.toResponse(pantryItemService.update(id, request));
    }

    // DELETE /api/pantry/{id} -- "Spaghetti aufgebraucht"
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        pantryItemService.delete(id);
    }

    // GET /api/pantry/matching-recipes -- KERNFUNKTION: welche Rezepte kann ich kochen?
    @GetMapping("/matching-recipes")
    public List<RecipeResponse> getMatchingRecipes() {
        return pantryItemService.findMatchingRecipes().stream()
                .map(RecipeMapper::toResponse)
                .toList();
    }
}
