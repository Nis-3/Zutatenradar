package de.jakueche.jannis.zutatenradar.dto;

// TODO: DTO fuer eingehende Rezept-Daten (was der Client schickt, OHNE id)
//
// Java Record -- immutable, kein Boilerplate:
//   public record RecipeRequest(
//       @NotBlank String name,
//       @Size(max = 2000) String description,
//       String imageUrl,
//       @NotNull Long categoryId
//   ) {}
//
// Bean Validation Annotationen sorgen dafuer, dass @Valid im Controller
// automatisch prueft (Pflichtanforderung #5).

public class RecipeRequest {
}
