package de.jakueche.jannis.zutatenradar.dto;

// Was das Backend zurueckgibt fuer eine Kategorie
public record CategoryResponse(
    Long id,
    String name
) {}
