package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Supplier;
import com.studies.stock_manager.repositories.interfaces.SupplierJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierRepository {
    private final SupplierJpaRepository supplierJpaRepository;

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

    public void update(long id, Supplier futureSupplier) {
        Supplier supplierDatabase = supplierJpaRepository.findById(id).get();
        BeanUtils.copyProperties(futureSupplier, supplierDatabase, "id");
        supplierJpaRepository.save(supplierDatabase);
    }
}
