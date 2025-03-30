package com.studies.stock_manager.repositories.interfaces;
import com.studies.stock_manager.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository  extends JpaRepository<Product, Long> {}
