package de.jakueche.jannis.zutatenradar.mapper;

import de.jakueche.jannis.zutatenradar.dto.CategoryResponse;
import de.jakueche.jannis.zutatenradar.model.Category;

public final class CategoryMapper {

    private CategoryMapper() {}

    // Entity → Response-DTO (zum Zurückschicken)
    public static CategoryResponse toResponse(Category entity) {
        return new CategoryResponse(
            entity.getId(),
            entity.getName()
        );
    }
}
