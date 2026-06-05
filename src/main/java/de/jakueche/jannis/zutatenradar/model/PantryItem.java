package de.jakueche.jannis.zutatenradar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PantryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;    // z.B. "Spaghetti", "Eier", "Käse"
    private String amount;  // z.B. "500g", "6 Stück", "200g"

    // Keine Beziehung zu Recipe -- das sind DEINE Zutaten,
    // unabhaengig von jedem Rezept. Loeschst du ein Rezept,
    // bleiben deine PantryItems bestehen.
}
