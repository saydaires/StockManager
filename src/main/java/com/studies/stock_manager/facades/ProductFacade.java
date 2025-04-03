package com.studies.stock_manager.facades;
import com.studies.stock_manager.entities.Product;
import com.studies.stock_manager.services.ProductService;
import java.util.List;

public class ProductFacade {
    private ProductService productService;

    public ProductFacade(ProductService productService) {
        this.productService = productService;
    }

    public void create(Product product) {
        productService.create(product);
    }

    public Product getById(long id) {
        return productService.getById(id);
    }

    public List<Product> getAll() {
        return productService.getAll();
    }

    public void update(long id, Product product) {
        productService.update(id, product);
    }

    public void delete(long id) {
        productService.delete(id);
    }
}
