package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Product;
import com.studies.stock_manager.repositories.interfaces.ProductJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private ProductJpaRepository productJpaRepository;

    public ProductRepository(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    public void create(Product product) {
        productJpaRepository.save(product);
    }

    public Product getById(long id) {
        return productJpaRepository.findById(id).get();
    }

    public List<Product> getAll() {
        return productJpaRepository.findAll();
    }

    public void delete(Product product) {
        productJpaRepository.delete(product);
    }

    public void update(Product futureProduct) {
        Product productDatabase = productJpaRepository.findById(futureProduct.getId()).get();

        productDatabase.setStock(futureProduct.getStock());
        productDatabase.setPrice(futureProduct.getPrice());
        productDatabase.setDescription(futureProduct.getDescription());

        productJpaRepository.save(productDatabase);
    }
}
