package de.jakueche.jannis.zutatenradar.dto;

// Was das Backend zurueckgibt fuer eine Zutat
public record IngredientResponse(
    Long id,
    String name,
    String amount
) {}
