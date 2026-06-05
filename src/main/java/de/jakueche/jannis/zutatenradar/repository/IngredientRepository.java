package de.jakueche.jannis.zutatenradar.repository;

import de.jakueche.jannis.zutatenradar.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository<Ingredient, Long> gibt dir kostenlos:
//   findAll(), findById(), save(), deleteById(), count(), existsById()
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    // Alle Zutaten eines Rezepts finden
    // SELECT * FROM ingredient WHERE recipe_id = ?
    List<Ingredient> findByRecipeId(Long recipeId);
}
