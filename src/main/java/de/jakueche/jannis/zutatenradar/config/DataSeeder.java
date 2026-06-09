package de.jakueche.jannis.zutatenradar.config;

import de.jakueche.jannis.zutatenradar.model.Category;
import de.jakueche.jannis.zutatenradar.model.Ingredient;
import de.jakueche.jannis.zutatenradar.model.Recipe;
import de.jakueche.jannis.zutatenradar.repository.CategoryRepository;
import de.jakueche.jannis.zutatenradar.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDatabase(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        return args -> {
            // Nur einfügen wenn die DB leer ist (keine Duplikate)
            if (categoryRepository.count() > 0) {
                return;
            }

            // === Kategorien anlegen ===
            Category hauptgericht = categoryRepository.save(new Category(null, "Hauptgericht", null));
            Category dessert = categoryRepository.save(new Category(null, "Dessert", null));
            Category suppe = categoryRepository.save(new Category(null, "Suppe", null));
            Category salat = categoryRepository.save(new Category(null, "Salat", null));
            Category vegan = categoryRepository.save(new Category(null, "Vegan", null));

            // === Rezepte mit Zutaten anlegen ===

            // Spaghetti Carbonara
            Recipe carbonara = new Recipe();
            carbonara.setName("Spaghetti Carbonara");
            carbonara.setDescription("Klassisches italienisches Pastagericht mit Ei und Speck.");
            carbonara.setCategory(hauptgericht);
            carbonara.addIngredient(new Ingredient(null, "Spaghetti", "500g", null));
            carbonara.addIngredient(new Ingredient(null, "Eier", "4 Stück", null));
            carbonara.addIngredient(new Ingredient(null, "Speck", "200g", null));
            carbonara.addIngredient(new Ingredient(null, "Parmesan", "100g", null));
            recipeRepository.save(carbonara);

            // Tomatensuppe
            Recipe tomatensuppe = new Recipe();
            tomatensuppe.setName("Tomatensuppe");
            tomatensuppe.setDescription("Einfache cremige Tomatensuppe.");
            tomatensuppe.setCategory(suppe);
            tomatensuppe.addIngredient(new Ingredient(null, "Tomaten", "1kg", null));
            tomatensuppe.addIngredient(new Ingredient(null, "Zwiebel", "2 Stück", null));
            tomatensuppe.addIngredient(new Ingredient(null, "Knoblauch", "3 Zehen", null));
            tomatensuppe.addIngredient(new Ingredient(null, "Sahne", "200ml", null));
            recipeRepository.save(tomatensuppe);

            // Caesar Salad
            Recipe caesarSalad = new Recipe();
            caesarSalad.setName("Caesar Salad");
            caesarSalad.setDescription("Knackiger Salat mit Croutons und Parmesan.");
            caesarSalad.setCategory(salat);
            caesarSalad.addIngredient(new Ingredient(null, "Römersalat", "1 Kopf", null));
            caesarSalad.addIngredient(new Ingredient(null, "Croutons", "100g", null));
            caesarSalad.addIngredient(new Ingredient(null, "Parmesan", "50g", null));
            caesarSalad.addIngredient(new Ingredient(null, "Hähnchenbrust", "200g", null));
            recipeRepository.save(caesarSalad);

            // Schokoladenmousse
            Recipe mousse = new Recipe();
            mousse.setName("Schokoladenmousse");
            mousse.setDescription("Luftiges Dessert aus dunkler Schokolade.");
            mousse.setCategory(dessert);
            mousse.addIngredient(new Ingredient(null, "Zartbitterschokolade", "200g", null));
            mousse.addIngredient(new Ingredient(null, "Eier", "3 Stück", null));
            mousse.addIngredient(new Ingredient(null, "Sahne", "200ml", null));
            mousse.addIngredient(new Ingredient(null, "Zucker", "50g", null));
            recipeRepository.save(mousse);

            // Gemüsecurry (Vegan)
            Recipe curry = new Recipe();
            curry.setName("Gemüsecurry");
            curry.setDescription("Würziges veganes Curry mit Kokosmilch.");
            curry.setCategory(vegan);
            curry.addIngredient(new Ingredient(null, "Kichererbsen", "400g", null));
            curry.addIngredient(new Ingredient(null, "Kokosmilch", "400ml", null));
            curry.addIngredient(new Ingredient(null, "Paprika", "2 Stück", null));
            curry.addIngredient(new Ingredient(null, "Currypaste", "2 EL", null));
            curry.addIngredient(new Ingredient(null, "Reis", "300g", null));
            recipeRepository.save(curry);

            System.out.println("Seed-Daten geladen: 5 Kategorien, 5 Rezepte mit Zutaten");
        };
    }
}
