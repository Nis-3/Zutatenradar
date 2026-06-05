package de.jakueche.jannis.zutatenradar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity                  // Diese Klasse wird zu einer Datenbank-Tabelle "category"
@Getter                  // Lombok: generiert alle Getter
@Setter                  // Lombok: generiert alle Setter
@NoArgsConstructor       // Lombok: leerer Konstruktor (braucht JPA)
@AllArgsConstructor      // Lombok: Konstruktor mit allen Feldern
public class Category {

    @Id                                              // Primaerschluessel
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB vergibt die ID automatisch
    private Long id;

    private String name;  // z.B. "Hauptgericht", "Dessert", "Suppe", "Vegan"

    // Eine Kategorie hat viele Rezepte
    // mappedBy = "category" zeigt auf das Feld "category" in der Recipe-Klasse
    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes = new ArrayList<>();
}
