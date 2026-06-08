package de.jakueche.jannis.zutatenradar.service;

import de.jakueche.jannis.zutatenradar.dto.IngredientRequest;
import de.jakueche.jannis.zutatenradar.exception.RecipeNotFoundException;
import de.jakueche.jannis.zutatenradar.mapper.IngredientMapper;
import de.jakueche.jannis.zutatenradar.model.Ingredient;
import de.jakueche.jannis.zutatenradar.model.Recipe;
import de.jakueche.jannis.zutatenradar.repository.IngredientRepository;
import de.jakueche.jannis.zutatenradar.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public IngredientService(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    // Alle Zutaten eines bestimmten Rezepts
    public List<Ingredient> findByRecipeId(Long recipeId) {
        return ingredientRepository.findByRecipeId(recipeId);
    }

    // Neue Zutat zu einem Rezept hinzufügen
    public Ingredient create(Long recipeId, IngredientRequest request) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException(recipeId));
        Ingredient ingredient = IngredientMapper.toEntity(request, recipe);
        return ingredientRepository.save(ingredient);
    }

    // Zutat löschen
    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }
}
