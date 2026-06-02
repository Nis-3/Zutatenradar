package de.jakueche.jannis.zutatenradar.model;

// TODO: JPA-Entity fuer Rezeptkategorien (3. Entitaet fuer Pflichtanforderung #1)
//
// Felder:
//   - id (Long, @Id, @GeneratedValue)
//   - name (String) - z.B. "Vegan", "Dessert", "Hauptgericht", "Suppe"
//
// Beziehungen:
//   - @OneToMany(mappedBy = "category") -> Recipe
//     Eine Kategorie hat viele Rezepte
//
// Braucht: protected no-args Konstruktor (JPA), Getter/Setter

public class Category {
}
