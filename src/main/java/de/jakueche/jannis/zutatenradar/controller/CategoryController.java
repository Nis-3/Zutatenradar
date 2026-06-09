package de.jakueche.jannis.zutatenradar.controller;

import de.jakueche.jannis.zutatenradar.dto.CategoryResponse;
import de.jakueche.jannis.zutatenradar.dto.RecipeResponse;
import de.jakueche.jannis.zutatenradar.mapper.CategoryMapper;
import de.jakueche.jannis.zutatenradar.mapper.RecipeMapper;
import de.jakueche.jannis.zutatenradar.repository.CategoryRepository;
import de.jakueche.jannis.zutatenradar.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final RecipeService recipeService;

    public CategoryController(CategoryRepository categoryRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.recipeService = recipeService;
    }

    // GET /api/categories -- alle Kategorien auflisten
    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    // GET /api/categories/{id}/recipes -- alle Rezepte einer Kategorie
    @GetMapping("/{id}/recipes")
    public List<RecipeResponse> getRecipesByCategory(@PathVariable Long id) {
        return recipeService.findByCategoryId(id).stream()
                .map(RecipeMapper::toResponse)
                .toList();
    }
}
