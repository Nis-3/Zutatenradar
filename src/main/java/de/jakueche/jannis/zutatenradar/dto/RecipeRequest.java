package de.jakueche.jannis.zutatenradar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Was das Frontend schickt wenn ein Rezept erstellt/bearbeitet wird (OHNE id)
public record RecipeRequest(

    @NotBlank(message = "Name darf nicht leer sein")
    @Size(max = 200, message = "Name darf maximal 200 Zeichen haben")
    String name,

    @Size(max = 2000, message = "Beschreibung darf maximal 2000 Zeichen haben")
    String description,

    String imageUrl,

    @NotNull(message = "Kategorie muss angegeben werden")
    Long categoryId
) {}
