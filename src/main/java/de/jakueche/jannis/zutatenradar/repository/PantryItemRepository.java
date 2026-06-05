package de.jakueche.jannis.zutatenradar.repository;

import de.jakueche.jannis.zutatenradar.model.PantryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PantryItemRepository extends JpaRepository<PantryItem, Long> {

    // Suche in deinen Vorraeten nach Name
    // SELECT * FROM pantry_item WHERE LOWER(name) LIKE '%...%'
    List<PantryItem> findByNameContainingIgnoreCase(String name);
}
