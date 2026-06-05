package de.jakueche.jannis.zutatenradar.repository;

import de.jakueche.jannis.zutatenradar.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<Category, Long> gibt dir kostenlos:
//   findAll(), findById(), save(), deleteById(), count(), existsById()
public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Spring generiert das SQL automatisch aus dem Methodennamen:
    // SELECT * FROM category WHERE LOWER(name) = LOWER(?)
    Optional<Category> findByNameIgnoreCase(String name);
}
