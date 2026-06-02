package de.jakueche.jannis.zutatenradar.exception;

// TODO: Zentraler Fehler-Handler fuer alle Controller (@RestControllerAdvice)
//
// Pflichtanforderung #6: Sinnvolle HTTP-Statuscodes und Fehlermeldungen.
// Nutzt ProblemDetail (RFC 7807) als einheitliches Fehlerformat.
//
// Exception-Handler Methoden:
//
//   @ExceptionHandler(RecipeNotFoundException.class)
//   -> HTTP 404 + ProblemDetail mit Fehlermeldung
//
//   @ExceptionHandler(MethodArgumentNotValidException.class)
//   -> HTTP 400 + ProblemDetail mit fieldErrors Map (welches Feld, welche Fehlermeldung)
//
//   @ExceptionHandler(ExternalApiException.class)
//   -> HTTP 502 Bad Gateway + ProblemDetail
//
//   @ExceptionHandler(Exception.class)
//   -> HTTP 500 als letzter Fallback (niemals Stack-Traces an den Client!)

public class GlobalExceptionHandler {
}
