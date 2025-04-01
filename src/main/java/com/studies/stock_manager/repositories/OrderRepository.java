package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.Order;
import com.studies.stock_manager.repositories.interfaces.OrderJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    public OrderRepository(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    public void create(Order order) {
        orderJpaRepository.save(order);
    }

    public Order getById(long id) {
        return orderJpaRepository.findById(id).get();
    }

    public List<Order> getAll() {
        return orderJpaRepository.findAll();
    }

    public void delete(long id) {
        orderJpaRepository.deleteById(id);
    }

    public void update(Order futureOrder) {
        Order orderDatabase = orderJpaRepository.findById(futureOrder.getId()).get();

        orderDatabase.setDeliveryDate(futureOrder.getDeliveryDate());
        orderDatabase.setOrderStatus(futureOrder.getOrderStatus());
        orderDatabase.setPayment(futureOrder.getPayment());

        orderJpaRepository.save(orderDatabase);
    }
}
