package de.jakueche.jannis.zutatenradar.dto;

import jakarta.validation.constraints.NotBlank;

// Was das Frontend schickt wenn du eine Zutat zu deinem Vorrat hinzufuegst
public record PantryItemRequest(

    @NotBlank(message = "Zutatenname darf nicht leer sein")
    String name,

    String amount  // Optional -- z.B. "500g" oder leer wenn du es nicht weisst
) {}
