package de.jakueche.jannis.zutatenradar.exception;

// Wird geworfen wenn die externe API (OpenFoodFacts) nicht erreichbar ist oder einen Fehler liefert.
// Der GlobalExceptionHandler fängt diese ab und gibt HTTP 502 Bad Gateway zurück.
public class ExternalApiException extends RuntimeException {

    public ExternalApiException(String message) {
        super(message);
    }

    public ExternalApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
