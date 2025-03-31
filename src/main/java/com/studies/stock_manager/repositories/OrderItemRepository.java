package com.studies.stock_manager.repositories;
import com.studies.stock_manager.entities.OrderItem;
import com.studies.stock_manager.repositories.interfaces.OrderItemJpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderItemRepository {
    private OrderItemJpaRepository orderItemJpaRepository;

    public OrderItemRepository(OrderItemJpaRepository orderItemJpaRepository) {
        this.orderItemJpaRepository = orderItemJpaRepository;
    }
    public void create(OrderItem orderItem) {
        orderItemJpaRepository.save(orderItem);
    }

    public OrderItem getById(long id) {
        return orderItemJpaRepository.findById(id).get();
    }

    public List<OrderItem> getAll() {
        return orderItemJpaRepository.findAll();
    }

    public void delete(long id) {
        orderItemJpaRepository.deleteById(id);
    }
}
