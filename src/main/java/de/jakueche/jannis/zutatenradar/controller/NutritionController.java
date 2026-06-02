package de.jakueche.jannis.zutatenradar.controller;

// TODO: REST-Controller fuer die externe API-Anbindung (@RestController, @RequestMapping("/api/nutrition"))
//
// Endpoints:
//   GET /api/nutrition/search?query=pasta  -> Produkte bei OpenFoodFacts suchen
//                                             Gibt Naehrwertdaten zurueck
//
// Bekommt OpenFoodFactsService per Constructor Injection.
// Das ist der Endpunkt, ueber den das Frontend die externe API-Daten abruft.
// Das Frontend spricht NIE direkt mit OpenFoodFacts -- immer ueber das Backend.

public class NutritionController {
}
