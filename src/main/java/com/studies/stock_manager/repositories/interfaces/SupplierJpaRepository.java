package com.studies.stock_manager.repositories.interfaces;
import com.studies.stock_manager.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierJpaRepository extends JpaRepository<Supplier, Long> {}
