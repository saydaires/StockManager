package com.studies.stock_manager.services;
import com.studies.stock_manager.entities.Product;
import com.studies.stock_manager.repositories.ProductRepository;
import com.studies.stock_manager.services.exceptions.DelayedRecordException;
import com.studies.stock_manager.services.exceptions.EntityNotFoundException;
import org.springframework.dao.OptimisticLockingFailureException;
import java.util.NoSuchElementException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product product) {
        productRepository.create(product);
    }

    public Product getById(long id) {
        try {
            return productRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new EntityNotFoundException("Product Not Found!", error);
        }
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void delete(long id) {
        try {
            productRepository.delete(id);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Field Id cannot be null!", error);
        }
    }

    public void update(Product product) {
        try {
            productRepository.update(product);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Object cannot be null!", error);
        }
        catch(OptimisticLockingFailureException error) {
            throw new DelayedRecordException("Application data in conflict with the database!", error);
        }
    }
}