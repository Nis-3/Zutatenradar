package de.jakueche.jannis.zutatenradar.mapper;

import de.jakueche.jannis.zutatenradar.dto.PantryItemRequest;
import de.jakueche.jannis.zutatenradar.dto.PantryItemResponse;
import de.jakueche.jannis.zutatenradar.model.PantryItem;

public final class PantryItemMapper {

    private PantryItemMapper() {}

    // Request-DTO → Entity (zum Speichern)
    public static PantryItem toEntity(PantryItemRequest request) {
        PantryItem item = new PantryItem();
        item.setName(request.name());
        item.setAmount(request.amount());
        return item;
    }

    // Entity → Response-DTO (zum Zurückschicken)
    public static PantryItemResponse toResponse(PantryItem entity) {
        return new PantryItemResponse(
            entity.getId(),
            entity.getName(),
            entity.getAmount()
        );
    }
}
