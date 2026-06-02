package de.jakueche.jannis.zutatenradar.config;

// TODO: Seed-Daten beim Anwendungsstart laden (@Configuration)
//
// Nutzt CommandLineRunner um beim Start Beispieldaten in die Datenbank zu schreiben.
// Nur wenn die DB leer ist (repository.count() == 0), damit keine Duplikate entstehen.
//
// Beispiel-Seed-Daten:
//
// Kategorien: "Hauptgericht", "Dessert", "Suppe", "Salat", "Vegan"
//
// Rezepte mit Zutaten:
//   - "Spaghetti Carbonara" (Hauptgericht) -> Spaghetti 500g, Eier 4 Stueck, Speck 200g, Parmesan 100g
//   - "Tomatensuppe" (Suppe) -> Tomaten 1kg, Zwiebel 2 Stueck, Knoblauch 3 Zehen
//   - "Caesar Salad" (Salat) -> Roemersalat 1 Kopf, Croutons 100g, Parmesan 50g
//
// Analog zum DataSeeder aus Vorlesung 5.

public class DataSeeder {
}
