package com.studies.stock_manager.controllers;

import com.studies.stock_manager.entities.Supplier;
import com.studies.stock_manager.facades.SupplierFacade;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock-manager/supplier")
public class SupplierController {
    private final SupplierFacade supplierFacade;

    public SupplierController(SupplierFacade supplierFacade) {
        this.supplierFacade = supplierFacade;
    }

    @PostMapping
    public void create(@RequestBody Supplier supplier) {
        supplierFacade.create(supplier);

    }

    @GetMapping({"/id/{id}"})
    public Supplier getById(@PathVariable long id) {
        return supplierFacade.getById(id);
    }

    @GetMapping
    public List<Supplier> getAll() {
        return supplierFacade.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        supplierFacade.delete(id);
    }

    @PutMapping({"/{id}"})
    public void update(@PathVariable long id, @RequestBody Supplier supplier) {
        supplierFacade.update(id, supplier);
    }
}
