package de.jakueche.jannis.zutatenradar.dto;

import java.util.List;

// Was das Backend zurueckgibt wenn ein Rezept abgefragt wird (MIT id)
public record RecipeResponse(
    Long id,
    String name,
    String description,
    String imageUrl,
    String categoryName,                  // Nur der Name, nicht die ganze Entity
    List<IngredientResponse> ingredients  // Zutaten als eigene DTOs
) {}
