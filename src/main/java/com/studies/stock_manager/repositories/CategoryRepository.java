package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Category;
import com.studies.stock_manager.repositories.interfaces.CategoryJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {
    private CategoryJpaRepository categoryJpaRepository;

    public CategoryRepository(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    public void create(Category category) {
        categoryJpaRepository.save(category);
    }

    public Category getById(long id) {
        return categoryJpaRepository.findById(id).get();
    }

    public List<Category> getAll() {
        return categoryJpaRepository.findAll();
    }

    public void delete(long id) {
        categoryJpaRepository.deleteById(id);
    }

    public void update(Category futureCategory) {
        Category categoryDatabase = categoryJpaRepository.findById(futureCategory.getId()).get();

        categoryDatabase.setName(futureCategory.getName());

        categoryJpaRepository.save(categoryDatabase);
    }
}
