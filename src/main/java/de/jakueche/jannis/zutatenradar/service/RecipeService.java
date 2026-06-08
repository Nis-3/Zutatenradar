package de.jakueche.jannis.zutatenradar.service;

import de.jakueche.jannis.zutatenradar.dto.RecipeRequest;
import de.jakueche.jannis.zutatenradar.exception.RecipeNotFoundException;
import de.jakueche.jannis.zutatenradar.mapper.RecipeMapper;
import de.jakueche.jannis.zutatenradar.model.Category;
import de.jakueche.jannis.zutatenradar.model.Recipe;
import de.jakueche.jannis.zutatenradar.repository.CategoryRepository;
import de.jakueche.jannis.zutatenradar.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;

    // Constructor Injection -- Spring gibt die Repositories automatisch rein
    public RecipeService(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
    }

    // Alle Rezepte holen
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    // Ein Rezept nach ID holen -- wirft Exception wenn nicht gefunden
    public Recipe getOrThrow(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    // Alle Rezepte einer Kategorie
    public List<Recipe> findByCategoryId(Long categoryId) {
        return recipeRepository.findByCategoryId(categoryId);
    }

    // Rezepte nach Name suchen
    public List<Recipe> searchByName(String query) {
        return recipeRepository.findByNameContainingIgnoreCase(query);
    }

    // Neues Rezept erstellen
    public Recipe create(RecipeRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Kategorie mit ID " + request.categoryId() + " nicht gefunden"));
        Recipe recipe = RecipeMapper.toEntity(request, category);
        return recipeRepository.save(recipe);
    }

    // Bestehendes Rezept aktualisieren
    public Recipe update(Long id, RecipeRequest request) {
        Recipe existing = getOrThrow(id);
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Kategorie mit ID " + request.categoryId() + " nicht gefunden"));

        existing.setName(request.name());
        existing.setDescription(request.description());
        existing.setImageUrl(request.imageUrl());
        existing.setCategory(category);

        return recipeRepository.save(existing);
    }

    // Rezept löschen
    public void delete(Long id) {
        if (!recipeRepository.existsById(id)) {
            throw new RecipeNotFoundException(id);
        }
        recipeRepository.deleteById(id);
    }
}
