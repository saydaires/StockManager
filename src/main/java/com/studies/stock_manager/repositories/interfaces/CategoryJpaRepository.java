package com.studies.stock_manager.repositories.interfaces;
import com.studies.stock_manager.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category, Long> {}
