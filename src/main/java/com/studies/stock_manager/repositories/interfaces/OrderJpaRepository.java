package com.studies.stock_manager.repositories.interfaces;
import com.studies.stock_manager.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {}
