package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Supplier;
import com.studies.stock_manager.repositories.interfaces.SupplierJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierRepository {
    private SupplierJpaRepository supplierJpaRepository;

    public SupplierRepository(SupplierJpaRepository supplierJpaRepository) {
        this.supplierJpaRepository = supplierJpaRepository;
    }

    public void create(Supplier supplier) {
        supplierJpaRepository.save(supplier);
    }

    public Supplier getById(long id) {
        return supplierJpaRepository.findById(id).get();
    }

    public List<Supplier> getAll() {
        return supplierJpaRepository.findAll();
    }

    public void delete(long id) {
        supplierJpaRepository.deleteById(id);
    }

    public void update(Supplier futureSupplier) {
        Supplier supplierDatabase = supplierJpaRepository.findById(futureSupplier.getId()).get();

        supplierDatabase.setName(futureSupplier.getName());
        supplierDatabase.setContact(futureSupplier.getContact());

        supplierJpaRepository.save(supplierDatabase);
    }
}
