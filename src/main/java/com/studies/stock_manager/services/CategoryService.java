package com.studies.stock_manager.services;
import com.studies.stock_manager.entities.Category;
import com.studies.stock_manager.repositories.CategoryRepository;
import com.studies.stock_manager.services.exceptions.category.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getById(long id) {
        try {
            return categoryRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new CategoryNotFoundException("Category Not Found!", error);
        }
    }
//    public void create(Category category) {}
//    public void update(Category category) {}
//    public void delete(long id) {}
}
