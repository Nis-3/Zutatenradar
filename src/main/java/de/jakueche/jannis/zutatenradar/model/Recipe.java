package de.jakueche.jannis.zutatenradar.model;

// TODO: JPA-Entity fuer ein Rezept
//
// Felder:
//   - id (Long, @Id, @GeneratedValue)
//   - name (String) - z.B. "Spaghetti Carbonara"
//   - description (String) - Kurzbeschreibung / Zubereitungsanleitung
//   - imageUrl (String) - optionales Bild
//
// Beziehungen:
//   - @ManyToOne -> Category (jedes Rezept gehoert zu einer Kategorie)
//   - @OneToMany -> Ingredient (ein Rezept hat viele Zutaten)
//
// Braucht: protected no-args Konstruktor (JPA), Getter/Setter, Komfortmethoden
//          fuer addIngredient/removeIngredient (bidirektionale Beziehung synchron halten)

public class Recipe {
}
