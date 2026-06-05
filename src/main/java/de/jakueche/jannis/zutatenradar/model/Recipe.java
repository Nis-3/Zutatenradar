package de.jakueche.jannis.zutatenradar.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;         // z.B. "Spaghetti Carbonara"
    private String description;  // Kurzbeschreibung oder Zubereitungsanleitung
    private String imageUrl;     // optionales Bild-URL

    // Viele Rezepte gehoeren zu einer Kategorie
    @ManyToOne
    @JoinColumn(name = "category_id") // Fremdschluessel-Spalte in der recipe-Tabelle
    private Category category;

    // Ein Rezept hat viele Zutaten
    // CascadeType.ALL: wenn ein Rezept geloescht wird, werden seine Zutaten auch geloescht
    // orphanRemoval: entfernte Zutaten werden aus der DB geloescht
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    // Komfortmethoden: halten beide Seiten der Beziehung synchron
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
        ingredient.setRecipe(null);
    }
}
