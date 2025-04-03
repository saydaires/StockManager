package com.studies.stock_manager.controllers;

import com.studies.stock_manager.entities.Product;
import com.studies.stock_manager.facades.ProductFacade;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock-manager/product")
public class ProductController {
    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @PostMapping
    public void create(@RequestBody Product product) {
        productFacade.create(product);

    }

    @GetMapping({"/id/{id}"})
    public Product getById(@PathVariable long id) {
        return productFacade.getById(id);
    }

    @GetMapping
    public List<Product> getAll() {
        return productFacade.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productFacade.delete(id);
    }

    @PutMapping({"/{id}"})
    public void update(@PathVariable long id, @RequestBody Product product) {
        productFacade.update(id, product);
    }
}
