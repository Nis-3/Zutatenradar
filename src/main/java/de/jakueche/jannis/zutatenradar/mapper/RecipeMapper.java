package de.jakueche.jannis.zutatenradar.mapper;

import de.jakueche.jannis.zutatenradar.dto.RecipeRequest;
import de.jakueche.jannis.zutatenradar.dto.RecipeResponse;
import de.jakueche.jannis.zutatenradar.model.Category;
import de.jakueche.jannis.zutatenradar.model.Recipe;

import java.util.Collections;

public final class RecipeMapper {

    private RecipeMapper() {}

    // Request-DTO → Entity (zum Speichern in der Datenbank)
    public static Recipe toEntity(RecipeRequest request, Category category) {
        Recipe recipe = new Recipe();
        recipe.setName(request.name());
        recipe.setDescription(request.description());
        recipe.setImageUrl(request.imageUrl());
        recipe.setCategory(category);
        return recipe;
    }

    // Entity → Response-DTO (zum Zurückschicken ans Frontend)
    public static RecipeResponse toResponse(Recipe entity) {
        return new RecipeResponse(
            entity.getId(),
            entity.getName(),
            entity.getDescription(),
            entity.getImageUrl(),
            entity.getCategory() != null ? entity.getCategory().getName() : null,
            entity.getIngredients() != null
                ? entity.getIngredients().stream()
                    .map(IngredientMapper::toResponse)
                    .toList()
                : Collections.emptyList()
        );
    }
}
