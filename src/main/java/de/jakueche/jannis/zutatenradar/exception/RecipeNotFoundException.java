package de.jakueche.jannis.zutatenradar.exception;

// Wird geworfen wenn ein Rezept mit einer bestimmten ID nicht existiert.
// Der GlobalExceptionHandler fängt diese ab und gibt HTTP 404 zurück.
public class RecipeNotFoundException extends RuntimeException {

    public RecipeNotFoundException(Long id) {
        super("Rezept mit ID " + id + " nicht gefunden");
    }
}
