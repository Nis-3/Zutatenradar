package de.jakueche.jannis.zutatenradar.mapper;

import de.jakueche.jannis.zutatenradar.dto.IngredientRequest;
import de.jakueche.jannis.zutatenradar.dto.IngredientResponse;
import de.jakueche.jannis.zutatenradar.model.Ingredient;
import de.jakueche.jannis.zutatenradar.model.Recipe;

public final class IngredientMapper {

    private IngredientMapper() {}

    // Request-DTO → Entity (zum Speichern)
    public static Ingredient toEntity(IngredientRequest request, Recipe recipe) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(request.name());
        ingredient.setAmount(request.amount());
        ingredient.setRecipe(recipe);
        return ingredient;
    }

    // Entity → Response-DTO (zum Zurückschicken)
    public static IngredientResponse toResponse(Ingredient entity) {
        return new IngredientResponse(
            entity.getId(),
            entity.getName(),
            entity.getAmount()
        );
    }
}
