package de.jakueche.jannis.zutatenradar.service;

import de.jakueche.jannis.zutatenradar.dto.PantryItemRequest;
import de.jakueche.jannis.zutatenradar.mapper.PantryItemMapper;
import de.jakueche.jannis.zutatenradar.model.PantryItem;
import de.jakueche.jannis.zutatenradar.model.Recipe;
import de.jakueche.jannis.zutatenradar.repository.PantryItemRepository;
import de.jakueche.jannis.zutatenradar.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantryItemService {

    private final PantryItemRepository pantryItemRepository;
    private final RecipeRepository recipeRepository;

    public PantryItemService(PantryItemRepository pantryItemRepository, RecipeRepository recipeRepository) {
        this.pantryItemRepository = pantryItemRepository;
        this.recipeRepository = recipeRepository;
    }

    // Alle Vorräte auflisten
    public List<PantryItem> findAll() {
        return pantryItemRepository.findAll();
    }

    // Neuen Vorratsartikel hinzufügen ("Ich habe Spaghetti")
    public PantryItem create(PantryItemRequest request) {
        PantryItem item = PantryItemMapper.toEntity(request);
        return pantryItemRepository.save(item);
    }

    // Vorratsartikel aktualisieren (z.B. Menge ändern)
    public PantryItem update(Long id, PantryItemRequest request) {
        PantryItem existing = pantryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vorratsartikel mit ID " + id + " nicht gefunden"));
        existing.setName(request.name());
        existing.setAmount(request.amount());
        return pantryItemRepository.save(existing);
    }

    // Vorratsartikel löschen ("Spaghetti aufgebraucht")
    public void delete(Long id) {
        pantryItemRepository.deleteById(id);
    }

    // === KERNFUNKTION DER APP ===
    // Vergleicht deine Vorräte mit den Rezept-Zutaten.
    // Gibt Rezepte zurück bei denen du mindestens eine Zutat hast.
    public List<Recipe> findMatchingRecipes() {
        // Alle Namen deiner Vorräte sammeln (kleingeschrieben für Vergleich)
        List<String> pantryNames = pantryItemRepository.findAll().stream()
                .map(item -> item.getName().toLowerCase())
                .toList();

        // Alle Rezepte durchgehen und prüfen ob mindestens eine Zutat passt
        return recipeRepository.findAll().stream()
                .filter(recipe -> recipe.getIngredients().stream()
                        .anyMatch(ingredient -> pantryNames.contains(ingredient.getName().toLowerCase())))
                .toList();
    }
}
