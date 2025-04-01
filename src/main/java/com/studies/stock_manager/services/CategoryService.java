package com.studies.stock_manager.services;
import com.studies.stock_manager.entities.Category;
import com.studies.stock_manager.repositories.CategoryRepository;
import com.studies.stock_manager.services.exceptions.EntityNotFoundException;
import com.studies.stock_manager.services.exceptions.DelayedRecordException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void create(Category category) {
        categoryRepository.create(category);
    }

    public Category getById(long id) {
        try {
            return categoryRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new EntityNotFoundException("Category Not Found!", error);
        }
    }

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public void delete(long id) {
        try {
            categoryRepository.delete(id);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Object cannot be null!", error);
        }
    }

    public void update(Category category) {
        try {
            categoryRepository.update(category);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Object cannot be null!", error);
        }
        catch(OptimisticLockingFailureException error) {
            throw new DelayedRecordException("Application data in conflict with the database!", error);
        }
    }
}
