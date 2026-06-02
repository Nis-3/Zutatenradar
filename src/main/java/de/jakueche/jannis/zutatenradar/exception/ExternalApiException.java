package de.jakueche.jannis.zutatenradar.exception;

// TODO: Exception fuer Fehler bei externen API-Aufrufen (OpenFoodFacts)
//
// Erweitert RuntimeException.
// Wird in OpenFoodFactsService geworfen, wenn die externe API nicht erreichbar ist
// oder einen Fehler zurueckgibt.
//
// Zwei Konstruktoren (wie in Vorlesung 7):
//   public ExternalApiException(String message) { super(message); }
//   public ExternalApiException(String message, Throwable cause) { super(message, cause); }
//
// GlobalExceptionHandler mapped diese auf HTTP 502 Bad Gateway.

public class ExternalApiException {
}
