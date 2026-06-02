package de.jakueche.jannis.zutatenradar.controller;

// TODO: REST-Controller fuer Rezepte (@RestController, @RequestMapping("/api/recipes"))
//
// Bekommt RecipeService per Constructor Injection.
//
// Endpoints (vollstaendiges CRUD -- Pflichtanforderung #2):
//   GET    /api/recipes              -> alle Rezepte (Listenansicht)
//   GET    /api/recipes/{id}         -> einzelnes Rezept (Detailansicht)
//   POST   /api/recipes              -> neues Rezept anlegen (@Valid @RequestBody RecipeRequest)
//   PUT    /api/recipes/{id}         -> Rezept aktualisieren (@Valid @RequestBody RecipeRequest)
//   DELETE /api/recipes/{id}         -> Rezept loeschen (204 No Content)
//   GET    /api/recipes?category={id} -> nach Kategorie filtern (optional)
//
// Nutzt RecipeMapper fuer DTO <-> Entity Umwandlung.
// Gibt RecipeResponse-DTOs zurueck, nie die Entity direkt.

public class RecipeController {
}
