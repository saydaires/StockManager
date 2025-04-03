package com.studies.stock_manager.controllers;

import com.studies.stock_manager.entities.Category;
import com.studies.stock_manager.facades.CategoryFacade;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock-manager/category")
public class CategoryController {
    private final CategoryFacade categoryFacade;

    public CategoryController(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }

    @PostMapping
    public void create(@RequestBody Category category) {
        categoryFacade.create(category);

    }

    @GetMapping({"/id/{id}"})
    public Category getById(@PathVariable long id) {
        return categoryFacade.getBydId(id);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryFacade.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        categoryFacade.delete(id);
    }

    @PutMapping({"/{id}"})
    public void update(@PathVariable long id, @RequestBody Category category) {
        categoryFacade.update(id, category);
    }
}
