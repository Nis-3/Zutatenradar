package de.jakueche.jannis.zutatenradar.dto;

import jakarta.validation.constraints.NotBlank;

// Was das Frontend schickt wenn eine Zutat zu einem Rezept hinzugefuegt wird
public record IngredientRequest(

    @NotBlank(message = "Zutatenname darf nicht leer sein")
    String name,

    @NotBlank(message = "Menge darf nicht leer sein")
    String amount
) {}
