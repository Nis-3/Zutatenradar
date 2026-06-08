package de.jakueche.jannis.zutatenradar.dto;

// Was das Backend zurueckgibt fuer einen Vorratsartikel
public record PantryItemResponse(
    Long id,
    String name,
    String amount
) {}
