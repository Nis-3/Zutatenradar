package de.jakueche.jannis.zutatenradar.model;

// TODO: JPA-Entity fuer eine Zutat innerhalb eines Rezepts
//
// Felder:
//   - id (Long, @Id, @GeneratedValue)
//   - name (String) - z.B. "Spaghetti", "Ei", "Parmesan"
//   - amount (String) - z.B. "200g", "3 Stueck", "1 EL"
//
// Beziehungen:
//   - @ManyToOne -> Recipe (jede Zutat gehoert zu einem Rezept)
//     @JoinColumn(name = "recipe_id")
//
// Braucht: protected no-args Konstruktor (JPA), Getter/Setter

public class Ingredient {
}
