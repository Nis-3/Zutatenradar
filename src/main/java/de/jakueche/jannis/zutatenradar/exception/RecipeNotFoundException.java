package de.jakueche.jannis.zutatenradar.exception;

// TODO: Exception fuer "Rezept nicht gefunden"
//
// Erweitert RuntimeException.
// Wird im Service geworfen, wenn findById ein leeres Optional liefert.
// Der GlobalExceptionHandler faengt sie ab und gibt HTTP 404 + ProblemDetail zurueck.
//
// Konstruktor:
//   public RecipeNotFoundException(Long id) {
//       super("Recipe with id " + id + " not found");
//   }

public class RecipeNotFoundException {
}
