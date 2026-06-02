package de.jakueche.jannis.zutatenradar.repository;

// TODO: Spring Data JPA Repository fuer Recipe
//
// Erweitert JpaRepository<Recipe, Long> -- damit bekommst du kostenlos:
//   findAll(), findById(), save(), deleteById(), count(), existsById()
//
// Eigene abgeleitete Queries (Methodenname -> SQL automatisch):
//   - List<Recipe> findByCategoryId(Long categoryId)
//   - List<Recipe> findByNameContainingIgnoreCase(String name)
//
// Spaeter ggf. @Query fuer komplexere Suchen (z.B. Rezepte nach Zutaten filtern)

public interface RecipeRepository {
}
