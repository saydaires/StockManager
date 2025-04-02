package com.studies.stock_manager.facades;
import com.studies.stock_manager.entities.Supplier;
import com.studies.stock_manager.services.SupplierService;

import java.util.List;

public class SupplierFacade {
    private final SupplierService supplierService;

    public SupplierFacade(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    public void create(Supplier supplier) {
        supplierService.create(supplier);
    }

    public Supplier getBydId(long id) {
        return supplierService.getById(id);
    }

    public List<Supplier> getAll(long id) {
        return supplierService.getAll();
    }

    public void delete(long id) {
        supplierService.delete(id);
    }

    public void update(long id, Supplier supplier) {
        supplierService.update(id, supplier);
    }
}
