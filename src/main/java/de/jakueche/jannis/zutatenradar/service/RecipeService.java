package de.jakueche.jannis.zutatenradar.service;

// TODO: Geschaeftslogik fuer Rezepte (@Service)
//
// Bekommt RecipeRepository per Constructor Injection.
//
// Methoden:
//   - List<Recipe> findAll()
//   - Recipe getOrThrow(Long id) -- wirft RecipeNotFoundException wenn nicht gefunden
//   - Recipe create(Recipe entity)
//   - Recipe update(Long id, Recipe updated) -- bestehende Felder ueberschreiben
//   - void delete(Long id) -- wirft RecipeNotFoundException wenn nicht vorhanden
//   - List<Recipe> findByCategoryId(Long categoryId)
//   - List<Recipe> searchByName(String query)
//
// Spaeter: Methode zum Filtern nach vorhandenen Zutaten (Kernfeature!)

public class RecipeService {
}
