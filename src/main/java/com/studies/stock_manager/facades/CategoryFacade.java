package com.studies.stock_manager.facades;
import com.studies.stock_manager.entities.Category;
import com.studies.stock_manager.services.CategoryService;

import java.util.List;

public class CategoryFacade {
    private final CategoryService categoryService;

    public CategoryFacade(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public void create(Category category) {
        categoryService.create(category);
    }

    public Category getBydId(long id) {
        return categoryService.getById(id);
    }

    public List<Category> getAll(long id) {
        return categoryService.getAll();
    }

    public void delete(long id) {
        categoryService.delete(id);
    }

    public void update(long id, Category category) {
        categoryService.update(id, category);
    }
}
