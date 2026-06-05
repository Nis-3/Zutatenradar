package de.jakueche.jannis.zutatenradar.repository;

import de.jakueche.jannis.zutatenradar.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<Recipe, Long> gibt dir kostenlos:
//   findAll(), findById(), save(), deleteById(), count(), existsById()
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    // Alle Rezepte einer Kategorie finden
    // SELECT * FROM recipe WHERE category_id = ?
    List<Recipe> findByCategoryId(Long categoryId);

    // Rezepte nach Name suchen (Teilsuche, Gross/Klein egal)
    // SELECT * FROM recipe WHERE LOWER(name) LIKE LOWER('%suchbegriff%')
    List<Recipe> findByNameContainingIgnoreCase(String name);
}
