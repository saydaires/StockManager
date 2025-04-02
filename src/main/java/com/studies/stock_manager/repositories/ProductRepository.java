package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Product;
import com.studies.stock_manager.repositories.interfaces.ProductJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final ProductJpaRepository productJpaRepository;

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

    public void delete(long id) {
        productJpaRepository.deleteById(id);
    }

    public void update(long id, Product futureProduct) {
        Product productDatabase = productJpaRepository.findById(id).get();
        BeanUtils.copyProperties(futureProduct, productDatabase, "id");
        productJpaRepository.save(productDatabase);
    }
}
