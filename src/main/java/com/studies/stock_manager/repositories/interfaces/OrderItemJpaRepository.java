package com.studies.stock_manager.repositories.interfaces;
import com.studies.stock_manager.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository  extends JpaRepository<OrderItem, Long> {}
