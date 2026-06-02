package de.jakueche.jannis.zutatenradar.mapper;

// TODO: Mapper-Klasse fuer Recipe Entity <-> DTO Umwandlung
//
// Statische Utility-Klasse (private Konstruktor, nur static Methoden):
//
//   public static Recipe toEntity(RecipeRequest request, Category category)
//     -> Erzeugt eine neue Recipe-Entity aus dem Request-DTO + der zugehoerigen Kategorie
//
//   public static RecipeResponse toResponse(Recipe entity)
//     -> Wandelt eine Recipe-Entity in ein Response-DTO um
//        Inkl. categoryName und Liste der Ingredients als IngredientResponse
//
// Analog zum TrackedObjectMapper aus der Vorlesung.

public final class RecipeMapper {
    private RecipeMapper() {}
}
